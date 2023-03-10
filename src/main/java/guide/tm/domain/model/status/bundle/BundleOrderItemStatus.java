package guide.tm.domain.model.status.bundle;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.shipping.status.ShippingStatus;
import guide.tm.domain.primitive.Quantity;

/**
 * セット品の受注明細と引当
 */
public class BundleOrderItemStatus {

    BundleProductOrderItem bundleProductOrderItem;
    BundleAllocation bundleAllocation;
    ShippingStatus shippingStatus;

    public BundleOrderItemStatus(BundleProductOrderItem bundleProductOrderItem, BundleAllocation bundleAllocation, ShippingStatus shippingStatus) {
        this.bundleProductOrderItem = bundleProductOrderItem;
        this.bundleAllocation = bundleAllocation;
        this.shippingStatus = shippingStatus;
    }

    /**
     * 引当完了しているかを返却する
     */
    public boolean isAllAllocated() {
        return bundleAllocation.isAllocated(bundleProductOrderItem.quantity());
    }

    /**
     * 引当済数量を返却する
     */
    public Quantity allocatedQuantity() {
        return bundleAllocation.allocatedQuantity();
    }

    /**
     * 引当残数を返却する
     */
    public Quantity remainingQuantity() {
        return orderedQuantity().subtract(allocatedQuantity());
    }

    /**
     * 受注数量
     */
    Quantity orderedQuantity() {
        return bundleProductOrderItem.quantity();
    }

    public BundleProductOrderItem bundleProductOrderItem() {
        return bundleProductOrderItem;
    }

    public BundleAllocation bundleAllocation() {
        return bundleAllocation;
    }

    public ShippingStatus shippingStatus() {
        return shippingStatus;
    }

    public boolean isShippingInstructed() {
        return shippingStatus.isInstructed();
    }
}
