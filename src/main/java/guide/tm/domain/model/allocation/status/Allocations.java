package guide.tm.domain.model.allocation.status;

import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;

public class Allocations {
    SingleAllocations singleAllocations;
    BundleAllocations bundleAllocations;

    public Allocations(SingleAllocations singleAllocations, BundleAllocations bundleAllocations) {
        this.singleAllocations = singleAllocations;
        this.bundleAllocations = bundleAllocations;
    }
}
