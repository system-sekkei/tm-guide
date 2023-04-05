package guide.tm.application.service.shipping;

import guide.tm.domain.model.shipping.content.ShippingNumber;

public interface ShippingRepository {
    void markAsShipped(ShippingNumber shippingNumber);
}
