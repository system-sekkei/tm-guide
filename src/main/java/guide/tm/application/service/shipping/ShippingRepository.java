package guide.tm.application.service.shipping;

import guide.tm.domain.model.allocation.salesorder.bundle.BundleOrderItemAllocations;
import guide.tm.domain.model.allocation.salesorder.single.SingleOrderItemAllocations;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;

public interface ShippingRepository {
    ShippingNumber register(
            Shipping shipping,
            SingleOrderItemAllocations singleOrderItemAllocations,
            BundleOrderItemAllocations bundleOrderItemAllocations);

    Shipping shippingOf(ShippingNumber shippingNumber);

}
