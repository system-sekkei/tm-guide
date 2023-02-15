package guide.tm.domain.model.allocation.allocation;

import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItems;

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

    public BundleProductOrderItems allocatedSaleOrderItems() {
        return new BundleProductOrderItems(
                list.stream()
                        .filter(BundleOrderItemAllocation::isAllAllocated)
                        .map(BundleOrderItemAllocation::bundleProductOrderItem)
                        .toList());
    }
}
