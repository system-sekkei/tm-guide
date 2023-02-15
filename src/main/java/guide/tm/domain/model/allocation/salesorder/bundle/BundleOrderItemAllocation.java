package guide.tm.domain.model.allocation.salesorder.bundle;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
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
        return bundleProductOrderItem.bundleProduct().bundleProductItems().list().stream().allMatch(
                product -> bundleAllocation.isAllocated(bundleProductOrderItem.quantity())
        );
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
}
