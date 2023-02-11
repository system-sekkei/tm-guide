package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;

/**
 * セット品の受注明細と引当
 */
public class BundleOrderItemAllocation {
    BundleProductOrderItem bundleProductOrderItem;
    BundleAllocation bundleAllocation;

    public BundleOrderItemAllocation(BundleProductOrderItem bundleProductOrderItem, BundleAllocation bundleAllocation) {
        this.bundleProductOrderItem = bundleProductOrderItem;
        this.bundleAllocation = bundleAllocation;
    }

    /**
     * 引当完了しているかを返却する
     */
    public boolean isAllAllocated() {
        return bundleProductOrderItem.product().bundleProductItems().list().stream().allMatch(
                product -> bundleAllocation.isAllocated(bundleProductOrderItem.quantity())
        );
    }

    public Quantity allocatedQuantity() {
        return bundleAllocation.allocatedQuantity();
    }

    public Quantity remainingQuantity() {
        return orderedQuantity().subtract(allocatedQuantity());
    }

    Quantity orderedQuantity() {
        return bundleProductOrderItem.quantity();
    }

    public BundleProductOrderItem bundleProductOrderItem() {
        return bundleProductOrderItem;
    }
}
