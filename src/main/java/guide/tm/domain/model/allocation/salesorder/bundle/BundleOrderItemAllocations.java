package guide.tm.domain.model.allocation.salesorder.bundle;

import java.util.List;

/**
 * セット品の受注明細と引当のリスト
 */
public class BundleOrderItemAllocations {
    List<BundleOrderItemAllocation> list;

    public BundleOrderItemAllocations(List<BundleOrderItemAllocation> list) {
        this.list = list;
    }

    public List<BundleOrderItemAllocation> list() {
        return list;
    }

    /**
     * 引当済の個別商品の受注明細と引当のリスト
     */
    public BundleOrderItemAllocations allocated() {
        return new BundleOrderItemAllocations(
                list.stream()
                        .filter(BundleOrderItemAllocation::isAllAllocated)
                        .toList());
    }

    public BundleOrderItemAllocations notShippedItemAllocations(BundleOrderItemAllocations shippedBundleItems) {
        return new BundleOrderItemAllocations(
                list.stream().filter(it -> !shippedBundleItems.contains(it))
                        .toList());
    }

    private boolean contains(BundleOrderItemAllocation bundleOrderItemAllocation) {
        return list.stream()
                .anyMatch(it -> it.bundleProductOrderItem.isSame(bundleOrderItemAllocation.bundleProductOrderItem()));
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
