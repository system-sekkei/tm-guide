package guide.tm.domain.model.status.bundle;

import guide.tm.domain.model.allocation.bundle.BundleAllocations;

import java.util.List;
import java.util.function.Consumer;

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

    /**
     * 出荷指示のないセット商品の引当を取得する
     */
    public BundleAllocations notShippedItemAllocations() {
        return new BundleAllocations(
                list.stream()
                        .filter(it -> !it.isShippingInstructed())
                        .map(BundleOrderItemStatus::bundleAllocation)
                        .toList());
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public void forEach(Consumer<BundleOrderItemStatus> consumer) {
        list.forEach(consumer);
    }

    public boolean isAllAllocated() {
        return list.stream().allMatch(BundleOrderItemStatus::isAllAllocated);
    }
}
