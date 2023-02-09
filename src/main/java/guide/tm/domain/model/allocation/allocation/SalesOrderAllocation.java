package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.salesorder.order.SalesOrder;

import java.util.List;

public class SalesOrderAllocation {
    SalesOrder salesOrder;
    Allocations allocations;

    public SalesOrderAllocation(SalesOrder salesOrder, Allocations allocations) {
        this.salesOrder = salesOrder;
        this.allocations = allocations;
    }

    public List<SalesOrderItemAllocation> salesOrderItemAllocations() {
        return salesOrder.salesOrderItems().list().stream()
                .map(salesOrderItem -> {
                    Allocation allocation = allocations.allocationOf(salesOrderItem);
                    return new SalesOrderItemAllocation(salesOrderItem, allocation);
                }).toList();
    }

    public SalesOrder salesOrder() {
        return salesOrder;
    }

}
