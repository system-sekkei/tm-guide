package guide.tm.domain.model.shipping.content;

import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;

/**
 * 出荷指示
 */
public class ShippingInstruction {

    ShippingInstructionContent shippingInstructionContent;
    SingleAllocations singleAllocations;
    BundleAllocations bundleAllocations;

    public ShippingInstruction(ShippingInstructionContent shippingInstructionContent, SingleAllocations singleAllocations, BundleAllocations bundleAllocations) {
        this.shippingInstructionContent = shippingInstructionContent;
        this.singleAllocations = singleAllocations;
        this.bundleAllocations = bundleAllocations;
    }

    public boolean isAllShipped() {
        return singleAllocations.isEmpty() && bundleAllocations.isEmpty();
    }

    public ShippingInstructionContent shippingInstructionContent() {
        return shippingInstructionContent;
    }

    public SingleAllocations singleAllocations() {
        return singleAllocations;
    }

    public BundleAllocations bundleAllocations() {
        return bundleAllocations;
    }
}
