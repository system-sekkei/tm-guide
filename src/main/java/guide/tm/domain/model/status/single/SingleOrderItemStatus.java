package guide.tm.domain.model.status.single;

import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;
import guide.tm.domain.model.shipping.item.ShippingStatus;
import guide.tm.domain.primitive.Quantity;

/**
 * 個別商品の引当/出荷状況
 */
public class SingleOrderItemStatus {
    SingleOrderItem singleOrderItem;
    SingleAllocation singleAllocation;
    ShippingStatus shippingStatus;

    public SingleOrderItemStatus(SingleOrderItem singleOrderItem, SingleAllocation singleAllocation, ShippingStatus shippingStatus) {
        this.singleOrderItem = singleOrderItem;
        this.singleAllocation = singleAllocation;
        this.shippingStatus = shippingStatus;
    }

    public SingleOrderItem singleOrderItem() {
        return singleOrderItem;
    }

    public SingleAllocation singleAllocation() {
        return singleAllocation;
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

    public ShippingStatus shippingStatus() {
        return shippingStatus;
    }

    public boolean isShippingInstructed() {
        return shippingStatus.isInstructed();
    }

}
