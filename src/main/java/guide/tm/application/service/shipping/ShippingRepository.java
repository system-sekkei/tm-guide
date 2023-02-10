package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItems;

public interface ShippingRepository {
    ShippingNumber register(Shipping shipping);

    Shipping shippingOf(ShippingNumber shippingNumber);

    void registerShippingItems(ShippingNumber shippingNumber, SalesOrderNumber salesOrderNumber, ShippingItems shippingItems);
}
