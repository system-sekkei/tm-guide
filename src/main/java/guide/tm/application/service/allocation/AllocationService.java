package guide.tm.application.service.allocation;

import guide.tm.application.service.stock.StockService;
import guide.tm.domain.model.allocation.allocation.AllocatedLocations;
import guide.tm.domain.model.allocation.allocation.Allocations;
import guide.tm.domain.model.allocation.allocation.BundleAllocations;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
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
        salesOrder.salesOrderItems().list().forEach(it -> allocate(it, salesOrderNumber));
        salesOrder.bundleProductOrderItems().list().forEach(it -> allocate(it, salesOrderNumber));
    }

    /**
     * 引当する
     */
    public void allocate(SalesOrderItem salesOrderItem, SalesOrderNumber salesOrderNumber) {
        Stocks stocks = stockService.stocksOf(salesOrderItem.product());
        AllocatedLocations allocatedLocations = stocks.allocate(salesOrderItem.quantity());
        allocationRepository.register(allocatedLocations, salesOrderNumber, salesOrderItem);
    }

    public Allocations allocationsOf(SalesOrderNumber salesOrderNumber) {
        return allocationRepository.allocationsOf(salesOrderNumber);
    }

    public BundleAllocations bundleAllocations(SalesOrderNumber salesOrderNumber) {
        return allocationRepository.bundleAllocationsOf(salesOrderNumber);
    }

    /**
     * 引当する
     */
    public void allocate(BundleProductOrderItem bundleProductOrderItem, SalesOrderNumber salesOrderNumber) {
        bundleProductOrderItem.product().bundleProductItems().list().forEach(it -> {
            Stocks stocks = stockService.stocksOf(it);
            AllocatedLocations allocatedLocations  = stocks.allocate(bundleProductOrderItem.quantity());
            allocationRepository.register(allocatedLocations, salesOrderNumber, bundleProductOrderItem.salesOrderItemNumber(), it);
        });
    }
}
