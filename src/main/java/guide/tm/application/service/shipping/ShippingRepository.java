package guide.tm.application.service.shipping;

import guide.tm.domain.model.allocation.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.allocation.status.single.SingleOrderItemStatusList;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;

public interface ShippingRepository {
    ShippingNumber register(
            Shipping shipping,
            SingleOrderItemStatusList singleOrderItemStatusList,
            BundleOrderItemStatusList bundleOrderItemStatusList);

}
