package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SingleOrderItem;
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
    public void register(ShippingNumber shippingNumber, SalesOrderNumber salesOrderNumber,  SingleOrderItem singleOrderItem) {
        ShippingItem shippingItem = ShippingItem.from(singleOrderItem);
        shippingItemRepository.register(shippingNumber, shippingItem, salesOrderNumber, singleOrderItem.salesOrderItemNumber());
    }

    /**
     * 出荷明細を取得する
     */
    public ShippingItems shippingItemsOf(ShippingNumber shippingNumber) {
        return shippingItemRepository.shippingItemsOf(shippingNumber);
    }

    public ShippingItems shippingItems(SalesOrderNumber salesOrderNumber) {
        return shippingItemRepository.shippingItems(salesOrderNumber);
    }
}
