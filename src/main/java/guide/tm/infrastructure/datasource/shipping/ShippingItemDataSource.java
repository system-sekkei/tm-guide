package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingItemRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItem;
import guide.tm.domain.model.shipping.item.ShippingItems;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ShippingItemDataSource implements ShippingItemRepository {

    ShippingItemMapper shippingItemMapper;

    ShippingItemDataSource(ShippingItemMapper shippingItemMapper) {
        this.shippingItemMapper = shippingItemMapper;
    }

    @Override
    public void register(
            ShippingNumber shippingNumber, ShippingItem shippingItem,
            SalesOrderNumber salesOrderNumber, SalesOrderItemNumber salesOrderItemNumber) {
        UUID shippingItemNumber = UUID.randomUUID();
        shippingItemMapper.register(shippingNumber, shippingItemNumber, shippingItem, salesOrderNumber, salesOrderItemNumber);
    }

    @Override
    public ShippingItems shippingItemsOf(ShippingNumber shippingNumber) {
        return new ShippingItems(shippingItemMapper.shippingItemsOf(shippingNumber));
    }

    @Override
    public ShippingItems shippingItems(SalesOrderNumber salesOrderNumber) {
        return new ShippingItems(shippingItemMapper.shippingItems(salesOrderNumber));
    }
}
