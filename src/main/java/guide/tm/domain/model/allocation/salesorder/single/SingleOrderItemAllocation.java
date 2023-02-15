package guide.tm.domain.model.allocation.salesorder.single;

import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;

/**
 * 受注明細と引当
 */
public class SingleOrderItemAllocation {
    SingleOrderItem singleOrderItem;
    SingleAllocation singleAllocation;

    public SingleOrderItemAllocation(SingleOrderItem singleOrderItem, SingleAllocation singleAllocation) {
        this.singleOrderItem = singleOrderItem;
        this.singleAllocation = singleAllocation;
    }

    public SingleOrderItem singleOrderItem() {
        return singleOrderItem;
    }

    /**
     * 引当完了しているかを返却する
     */
    public boolean isAllAllocated() {
        return singleOrderItem.quantity().isEqual(singleAllocation.allocatedQuantity());
    }

    /**
     * 引当済数量を返却する
     */
    public Quantity allocatedQuantity() {
        return singleAllocation.allocatedQuantity();
    }

    /**
     * 引当残数を返却する
     */
    public Quantity remainingQuantity() {
        return singleOrderItem.quantity().subtract(allocatedQuantity());
    }
}
