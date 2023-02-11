package guide.tm.domain.model.allocation.allocation;

import java.util.List;

public class BundleOrderItemAllocations {
    List<BundleOrderItemAllocation> list;

    public BundleOrderItemAllocations(List<BundleOrderItemAllocation> list) {
        this.list = list;
    }

    public List<BundleOrderItemAllocation> list() {
        return list;
    }


}
