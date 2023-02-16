package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.item.ShippingItems;

public interface ShippingItemRepository {
    ShippingItems shippingItems(SalesOrderNumber salesOrderNumber);
}
