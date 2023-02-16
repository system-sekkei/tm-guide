package guide.tm.application.service.shipping;

import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;

public interface ShippingRepository {
    ShippingNumber register(
            Shipping shipping,
            SingleAllocations singleAllocations,
            BundleAllocations bundleAllocations);
}
