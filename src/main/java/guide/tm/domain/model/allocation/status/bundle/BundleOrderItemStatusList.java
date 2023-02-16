package guide.tm.domain.model.allocation.status.bundle;

import java.util.List;

/**
 * セット品の受注明細と引当のリスト
 */
public class BundleOrderItemStatusList {
    List<BundleOrderItemStatus> list;

    public BundleOrderItemStatusList(List<BundleOrderItemStatus> list) {
        this.list = list;
    }

    public List<BundleOrderItemStatus> list() {
        return list;
    }

    /**
     * 引当済の個別商品の受注明細と引当のリスト
     */
    public BundleOrderItemStatusList allocated() {
        return new BundleOrderItemStatusList(
                list.stream()
                        .filter(BundleOrderItemStatus::isAllAllocated)
                        .toList());
    }

    public BundleOrderItemStatusList notShippedItemAllocations(BundleOrderItemStatusList shippedBundleItems) {
        return new BundleOrderItemStatusList(
                list.stream().filter(it -> !shippedBundleItems.contains(it))
                        .toList());
    }

    private boolean contains(BundleOrderItemStatus bundleOrderItemStatus) {
        return list.stream()
                .anyMatch(it -> it.bundleProductOrderItem.isSame(bundleOrderItemStatus.bundleProductOrderItem()));
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }
}
