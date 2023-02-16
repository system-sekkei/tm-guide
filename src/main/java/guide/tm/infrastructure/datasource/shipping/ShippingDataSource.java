package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingRepository;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
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
            SingleAllocations singleAllocations,
            BundleAllocations bundleAllocations) {
        UUID shippingNumber = UUID.randomUUID();
        shippingMapper.register(shipping, shippingNumber);

        singleAllocations.list().forEach(allocation ->
                shippingMapper.registerShippedAllocations(shippingNumber, allocation));

        bundleAllocations.list().forEach(allocation ->
                shippingMapper.registerShippedBundleAllocations(shippingNumber, allocation));

        return new ShippingNumber(shippingNumber.toString());
    }

}
