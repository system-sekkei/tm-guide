package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingItemRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.bundle.BundleShippingItems;
import guide.tm.domain.model.shipping.item.ShippingItems;
import guide.tm.domain.model.shipping.single.SingleShippingItems;
import org.springframework.stereotype.Service;

@Service
public class ShippingItemDataSource implements ShippingItemRepository {

    ShippingItemMapper shippingItemMapper;

    ShippingItemDataSource(ShippingItemMapper shippingItemMapper) {
        this.shippingItemMapper = shippingItemMapper;
    }

    @Override
    public ShippingItems shippingItems(SalesOrderNumber salesOrderNumber) {
        SingleShippingItems singleShippingItems = new SingleShippingItems(shippingItemMapper.singleShippingItems(salesOrderNumber));
        BundleShippingItems bundleShippingItems = new BundleShippingItems(shippingItemMapper.bundleShippingItems(salesOrderNumber));
        return new ShippingItems(singleShippingItems, bundleShippingItems);
    }
}
