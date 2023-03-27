package guide.tm.application.service.allocation;

import guide.tm.application.service.stock.StockService;
import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.content.Allocations;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.salesorder.content.ShippingAddress;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import guide.tm.domain.model.status.bundle.BundleOrderItemStatus;
import guide.tm.domain.model.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import guide.tm.domain.model.status.single.SingleOrderItemStatus;
import guide.tm.domain.model.status.single.SingleOrderItemStatusList;
import org.springframework.stereotype.Service;

/**
 * 引当サービス
 */
@Service
public class AllocationService {

    StockService stockService;
    AllocationRepository allocationRepository;

    AllocationService(StockService stockService, AllocationRepository allocationRepository) {
        this.stockService = stockService;
        this.allocationRepository = allocationRepository;
    }

    /**
     * 受注の引当を行う
     */
    public void allocateSalesOrder(SalesOrderStatus salesOrderStatus, SalesOrderId salesOrderId) {
        SingleOrderItemStatusList singleOrderItemStatusList = salesOrderStatus.singleOrderItemStatusList();
        BundleOrderItemStatusList bundleOrderItemStatusList = salesOrderStatus.bundleOrderItemStatusList();

        singleOrderItemStatusList.forEach(
                singleOrderItemStatus -> allocate(singleOrderItemStatus, salesOrderId, salesOrderStatus.salesOrder().salesOrderContent().shippingAddress()));
        bundleOrderItemStatusList.forEach(
                bundleOrderItemStatus -> allocate(bundleOrderItemStatus, salesOrderId, salesOrderStatus.salesOrder().salesOrderContent().shippingAddress()));
    }

    /**
     * 個別商品の引当を行う
     *
     * - 引当残がない場合は何もしない
     * - 引当残数の引当を行う
     */
    public void allocate(SingleOrderItemStatus singleOrderItemStatus, SalesOrderId salesOrderId, ShippingAddress shippingAddress) {
        SingleOrderItem singleOrderItem = singleOrderItemStatus.singleOrderItem();
        if (singleOrderItemStatus.isAllAllocated()) return;

        Stocks stocks = stockService.stocksOf(singleOrderItem.product());
        AllocatedLocations allocatedLocations = stocks.allocate(shippingAddress, singleOrderItem.quantity());
        allocationRepository.register(allocatedLocations, salesOrderId, singleOrderItem);
    }

    /**
     * 個別商品の引当を取得する
     */
    public SingleAllocations singleAllocationsOf(SalesOrderId salesOrderId) {
        return allocationRepository.singleAllocationsOf(salesOrderId);
    }

    /**
     * セット商品の引当を行う
     *
     * - 引当残がない場合は何もしない
     * - 引当残数の引当を行う
     */
    public void allocate(BundleOrderItemStatus bundleOrderItemStatus, SalesOrderId salesOrderId, ShippingAddress shippingAddress) {
        BundleProductOrderItem bundleProductOrderItem = bundleOrderItemStatus.bundleProductOrderItem();
        if (bundleOrderItemStatus.isAllAllocated()) return;

        BundleAllocationNumber bundleAllocationNumber =
                allocationRepository.registerBundleAllocation(salesOrderId, bundleProductOrderItem);
        bundleProductOrderItem.bundleProduct().bundleProductItems().list().forEach(singleProduct -> {
            Stocks stocks = stockService.stocksOf(singleProduct);
            AllocatedLocations allocatedLocations  = stocks.allocate(shippingAddress, bundleProductOrderItem.quantity());
            allocationRepository.registerBundleAllocationItem(bundleAllocationNumber, allocatedLocations, salesOrderId, singleProduct);
        });
    }

    /**
     * セット商品の引当を取得する
     */
    public BundleAllocations bundleAllocations(SalesOrderId salesOrderId) {
        return allocationRepository.bundleAllocations(salesOrderId);
    }

    /**
     * 引当を取得する
     */
    public Allocations allocationsOf(SalesOrderId salesOrderId) {
        return new Allocations(singleAllocationsOf(salesOrderId), bundleAllocations(salesOrderId));
    }

    /**
     * 引当完了を記録する
     */
    public void markAsCompleted(SalesOrderId salesOrderId) {
        allocationRepository.markAsCompleted(salesOrderId);
    }
}
