package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.item.ShippingItems;
import org.springframework.stereotype.Service;

@Service
public class ShippingItemService {
    ShippingItemRepository shippingItemRepository;

    ShippingItemService(ShippingItemRepository shippingItemRepository) {
        this.shippingItemRepository = shippingItemRepository;
    }

    public ShippingItems shippingItems(SalesOrderNumber salesOrderNumber) {
        return shippingItemRepository.shippingItems(salesOrderNumber);
    }
}
