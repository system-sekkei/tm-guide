package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItem;
import guide.tm.domain.model.shipping.item.ShippingItems;

public interface ShippingItemRepository {
    void register(ShippingNumber shippingNumber, ShippingItem shippingItem, SalesOrderNumber salesOrderNumber, SalesOrderItemNumber salesOrderItemNumber);

    ShippingItems shippingItemsOf(ShippingNumber shippingNumber);

    ShippingItems shippingItems(SalesOrderNumber salesOrderNumber);
}
