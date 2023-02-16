package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingRepository;
import guide.tm.domain.model.allocation.salesorder.bundle.BundleOrderItemAllocations;
import guide.tm.domain.model.allocation.salesorder.single.SingleOrderItemAllocations;
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
            SingleOrderItemAllocations singleOrderItemAllocations,
            BundleOrderItemAllocations bundleOrderItemAllocations) {
        UUID shippingNumber = UUID.randomUUID();
        shippingMapper.register(shipping, shippingNumber);

        singleOrderItemAllocations.list().forEach(allocation ->
                shippingMapper.registerShippedAllocations(shippingNumber, allocation));

        bundleOrderItemAllocations.list().forEach(allocation ->
                shippingMapper.registerShippedBundleAllocations(shippingNumber, allocation));

        return new ShippingNumber(shippingNumber.toString());
    }

    @Override
    public Shipping shippingOf(ShippingNumber shippingNumber) {
        return shippingMapper.shippingOf(shippingNumber);
    }

}
