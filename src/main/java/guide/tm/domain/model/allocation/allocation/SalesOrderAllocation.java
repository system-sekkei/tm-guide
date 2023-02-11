package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

public class SalesOrderAllocation {
    SalesOrderNumber salesOrderNumber;
    SalesOrder salesOrder;
    Allocations allocations;
    BundleAllocations bundleAllocations;

    public SalesOrderAllocation(SalesOrderNumber salesOrderNumber, SalesOrder salesOrder, Allocations allocations, BundleAllocations bundleAllocations) {
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrder = salesOrder;
        this.allocations = allocations;
        this.bundleAllocations = bundleAllocations;
    }

    public SalesOrderItemAllocations salesOrderItemAllocations() {
        return new SalesOrderItemAllocations(
                salesOrder.salesOrderItems().list().stream()
                        .map(salesOrderItem -> {
                            Allocation allocation = allocations.allocationOf(salesOrderItem);
                            return new SalesOrderItemAllocation(salesOrderItem, allocation);
                        }).toList());
    }

    public BundleOrderItemAllocations bundleProductOrderItemAllocations() {
        return new BundleOrderItemAllocations(
                salesOrder.bundleProductOrderItems().list().stream()
                .map(bundleProductOrderItem -> {
                    BundleAllocation bundleAllocation = bundleAllocations.allocationOf(bundleProductOrderItem);
                    return new BundleOrderItemAllocation(bundleProductOrderItem, bundleAllocation);
                }).toList());
    }

    public SalesOrder salesOrder() {
        return salesOrder;
    }

    public SalesOrderNumber salesOrderNumber() {
        return salesOrderNumber;
    }

}
