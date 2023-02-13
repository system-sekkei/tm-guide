package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;

import java.util.List;

/**
 * セット商品の引当のリスト
 */
public class BundleAllocations {
    List<BundleAllocation> list;

    public BundleAllocations(List<BundleAllocation> list) {
        this.list = list;
    }

    public BundleAllocation allocationOf(BundleProductOrderItem bundleProductOrderItem) {
        return list.stream()
                .filter(allocation -> allocation.isSame(bundleProductOrderItem.salesOrderItemNumber()))
                .findFirst()
                .orElse(new BundleAllocation());
    }
}
