package guide.tm.domain.model.allocation.single;

import guide.tm.domain.model.allocation.location.ProductAllocation;

/**
 * 引当
 */
public class SingleAllocation {
    SingleAllocationNumber singleAllocationNumber;
    ProductAllocation productAllocation;

    public SingleAllocation(SingleAllocationNumber singleAllocationNumber, ProductAllocation productAllocation) {
        this.singleAllocationNumber = singleAllocationNumber;
        this.productAllocation = productAllocation;
    }
}
