package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItems;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShippingDataSource implements ShippingRepository {

    ShippingMapper shippingMapper;

    ShippingDataSource(ShippingMapper shippingMapper) {
        this.shippingMapper = shippingMapper;
    }

//    @Override
//    public ShippingNumber register(Shipping shipping, SalesOrderItemAllocations salesOrderItemAllocations, BundleOrderItemAllocations bundleOrderItemAllocations) {
//        UUID shippingNumber = UUID.randomUUID();
//        shippingMapper.register(shipping, shippingNumber);
//
//        salesOrderItemAllocations.allocations().list().forEach(allocation -> {
//            shippingMapper.registerShippedAllocations(shippingNumber, allocation);
//        });
//
//        bundleOrderItemAllocations.allocations().list().forEach(allocation -> {
//            shippingMapper.registerShippedBundleAllocations(shippingNumber, allocation);
//        });
//
//        return new ShippingNumber(shippingNumber.toString());
//    }

    @Override
    public Shipping shippingOf(ShippingNumber shippingNumber) {
        return shippingMapper.shippingOf(shippingNumber);
    }

    @Override
    public void registerShippingItems(ShippingNumber shippingNumber, SalesOrderNumber salesOrderNumber, ShippingItems shippingItems) {
        shippingItems.list().forEach(shippingItem -> {
            UUID shippingItemNumber = UUID.randomUUID();
            shippingMapper.registerShippingItem(shippingNumber, shippingItemNumber, salesOrderNumber, shippingItem);
        });
    }
}
