package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;

/**
 * 引当
 */
public class Allocation {

    AllocationId allocationId;
    SalesOrderNumber salesOrderNumber;
    SalesOrderItemNumber salesOrderItemNumber;
    AllocationContents allocationContents;

    Allocation() {
        this(new AllocationId(), new SalesOrderNumber(), new SalesOrderItemNumber(), new AllocationContents());
    }

    public Allocation(
            AllocationId allocationId,
            SalesOrderNumber salesOrderNumber,
            SalesOrderItemNumber salesOrderItemNumber,
            AllocationContents allocationContents) {
        this.allocationId = allocationId;
        this.salesOrderNumber = salesOrderNumber;
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.allocationContents = allocationContents;
    }

    Quantity allocatedQuantity() {
        return allocationContents.allocatedQuantity();
    }

    boolean isSame(SalesOrderItemNumber salesOrderItemNumber) {
        return this.salesOrderItemNumber.isSame(salesOrderItemNumber);
    }
}
