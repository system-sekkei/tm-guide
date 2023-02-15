package guide.tm.application.service.allocation;

import guide.tm.application.service.stock.StockService;
import guide.tm.domain.model.allocation.bundle.BundleAllocationNumber;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;
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
    public void allocateSalesOrder(SalesOrder salesOrder, SalesOrderNumber salesOrderNumber) {
        salesOrder.singleProductOrderItems().list().forEach(it -> allocate(it, salesOrderNumber));
        salesOrder.bundleProductOrderItems().list().forEach(it -> allocate(it, salesOrderNumber));
    }

    /**
     * 個別商品の引当を行う
     */
    public void allocate(SingleOrderItem singleOrderItem, SalesOrderNumber salesOrderNumber) {
        Stocks stocks = stockService.stocksOf(singleOrderItem.product());
        AllocatedLocations allocatedLocations = stocks.allocate(singleOrderItem.quantity());
        allocationRepository.register(allocatedLocations, salesOrderNumber, singleOrderItem);
    }

    /**
     * 個別商品の引当を取得する
     */
    public SingleAllocations singleAllocationsOf(SalesOrderNumber salesOrderNumber) {
        return allocationRepository.singleAllocationsOf(salesOrderNumber);
    }

    /**
     * セット商品の引当を行う
     */
    public void allocate(BundleProductOrderItem bundleProductOrderItem, SalesOrderNumber salesOrderNumber) {
        BundleAllocationNumber bundleAllocationNumber =
                allocationRepository.registerBundleAllocation(salesOrderNumber, bundleProductOrderItem);
        bundleProductOrderItem.bundleProduct().bundleProductItems().list().forEach(singleProduct -> {
            Stocks stocks = stockService.stocksOf(singleProduct);
            AllocatedLocations allocatedLocations  = stocks.allocate(bundleProductOrderItem.quantity());
            allocationRepository.registerBundleAllocationItem(bundleAllocationNumber, allocatedLocations, salesOrderNumber, singleProduct);
        });
    }

    /**
     * セット商品の引当を取得する
     */
    public BundleAllocations bundleAllocations(SalesOrderNumber salesOrderNumber) {
        return allocationRepository.bundleAllocations(salesOrderNumber);
    }
}
