package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.item.ShippingItems;
import org.springframework.stereotype.Service;

/**
 * 出荷指示サービス
 */
@Service
public class ShippingItemService {
    ShippingItemRepository shippingItemRepository;

    ShippingItemService(ShippingItemRepository shippingItemRepository) {
        this.shippingItemRepository = shippingItemRepository;
    }

    /**
     * 出荷指示明細を取得する
     */
    public ShippingItems shippingItems(SalesOrderId salesOrderId) {
        return shippingItemRepository.shippingItems(salesOrderId);
    }
}
