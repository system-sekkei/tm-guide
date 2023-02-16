package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingRepository;
import guide.tm.domain.model.allocation.status.bundle.BundleOrderItemStatusList;
import guide.tm.domain.model.allocation.status.single.SingleOrderItemStatusList;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class ShippingDataSource implements ShippingRepository {

    ShippingMapper shippingMapper;

    ShippingDataSource(ShippingMapper shippingMapper) {
        this.shippingMapper = shippingMapper;
    }

    @Override
    public ShippingNumber register(
            Shipping shipping,
            SingleOrderItemStatusList singleOrderItemStatusList,
            BundleOrderItemStatusList bundleOrderItemStatusList) {
        UUID shippingNumber = UUID.randomUUID();
        shippingMapper.register(shipping, shippingNumber);

        singleOrderItemStatusList.list().forEach(allocation ->
                shippingMapper.registerShippedAllocations(shippingNumber, allocation));

        bundleOrderItemStatusList.list().forEach(allocation ->
                shippingMapper.registerShippedBundleAllocations(shippingNumber, allocation));

        return new ShippingNumber(shippingNumber.toString());
    }

}
