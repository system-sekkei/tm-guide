package guide.tm.application.service.shipping;

import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;

public interface ShippingRepository {
    ShippingNumber register(Shipping shipping);

    Shipping shippingOf(ShippingNumber shippingNumber);
}
