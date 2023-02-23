package guide.tm.application.service.shipping;

import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.shipping.content.ShippingInstructionContent;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingNumber;

public interface ShippingRepository {
    ShippingNumber register(
            ShippingInstructionContent shippingInstructionContent,
            SingleAllocations singleAllocations,
            BundleAllocations bundleAllocations);

    void markShipping(ShippingNumber shippingNumber);

    ShippingInstructionSummaries shippingInstructionSummaries();
}
