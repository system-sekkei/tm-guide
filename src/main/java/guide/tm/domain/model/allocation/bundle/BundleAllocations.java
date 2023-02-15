package guide.tm.domain.model.allocation.bundle;

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

    public BundleAllocation allocationOf(BundleProductOrderItem salesOrderItem) {
        return list.stream()
                .filter(allocation -> allocation.hasSameSalesOrderItemNumber(salesOrderItem.salesOrderItemNumber()))
                .findFirst()
                .orElse(new BundleAllocation());
    }
}
