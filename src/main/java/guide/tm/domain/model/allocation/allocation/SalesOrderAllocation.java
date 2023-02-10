package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

public class SalesOrderAllocation {
    SalesOrderNumber salesOrderNumber;
    SalesOrder salesOrder;
    Allocations allocations;

    public SalesOrderAllocation(SalesOrderNumber salesOrderNumber, SalesOrder salesOrder, Allocations allocations) {
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrder = salesOrder;
        this.allocations = allocations;
    }

    public SalesOrderItemAllocations salesOrderItemAllocations() {
        return new SalesOrderItemAllocations(
                salesOrder.salesOrderItems().list().stream()
                        .map(salesOrderItem -> {
                            Allocation allocation = allocations.allocationOf(salesOrderItem);
                            return new SalesOrderItemAllocation(salesOrderItem, allocation);
                        }).toList());
    }

    public SalesOrder salesOrder() {
        return salesOrder;
    }

    public SalesOrderNumber salesOrderNumber() {
        return salesOrderNumber;
    }

}
