package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;

public class BundleAllocation {
    SalesOrderNumber salesOrderNumber;
    SalesOrderItemNumber salesOrderItemNumber;
    AllocationContents allocationContents;

    public BundleAllocation() {
    }

    public BundleAllocation(SalesOrderNumber salesOrderNumber, SalesOrderItemNumber salesOrderItemNumber, AllocationContents allocationContents) {
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.allocationContents = allocationContents;
    }

    public boolean isSame(SalesOrderItemNumber salesOrderItemNumber) {
        return this.salesOrderItemNumber.isSame(salesOrderItemNumber);
    }

    boolean isAllocated(Quantity orderedQuantity) {
        return allocationContents.isAllAllocated(orderedQuantity);
    }

    Quantity allocatedQuantity() {
        return allocationContents.allocatedQuantity();
    }
}
