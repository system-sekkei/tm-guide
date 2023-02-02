package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItem;
import guide.tm.domain.model.shipping.item.ShippingItems;
import org.springframework.stereotype.Service;

@Service
public class ShippingItemService {
    ShippingItemRepository shippingItemRepository;

    ShippingItemService(ShippingItemRepository shippingItemRepository) {
        this.shippingItemRepository = shippingItemRepository;
    }

    /**
     * 出荷明細を登録する
     */
    public void register(ShippingNumber shippingNumber, SalesOrderNumber salesOrderNumber,  SalesOrderItem salesOrderItem) {
        ShippingItem shippingItem = ShippingItem.from(salesOrderItem);
        shippingItemRepository.register(shippingNumber, shippingItem, salesOrderNumber, salesOrderItem.salesOrderItemNumber());
    }

    /**
     * 出荷明細を取得する
     */
    public ShippingItems shippingItemsOf(ShippingNumber shippingNumber) {
        return shippingItemRepository.shippingItemsOf(shippingNumber);
    }
}
