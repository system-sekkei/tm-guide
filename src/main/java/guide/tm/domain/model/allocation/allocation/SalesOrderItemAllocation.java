package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;

public class SalesOrderItemAllocation {
    SalesOrderItem salesOrderItem;
    Allocation allocation;

    SalesOrderItemAllocation(SalesOrderItem salesOrderItem, Allocation allocation) {
        this.salesOrderItem = salesOrderItem;
        this.allocation = allocation;
    }

    /**
     * 引当完了しているかを返却する
     */
    public boolean isAllAllocated() {
        return salesOrderItem.quantity().isEqual(allocation.allocatedQuantity());
    }

    public SalesOrderItem salesOrderItem() {
        return salesOrderItem;
    }

    public Quantity allocatedQuantity() {
        return allocation.allocatedQuantity();
    }

    public Quantity remainingQuantity() {
        return salesOrderItem.quantity().subtract(allocatedQuantity());
    }
}
