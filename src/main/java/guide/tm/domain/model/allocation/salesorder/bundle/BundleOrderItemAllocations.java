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
}
