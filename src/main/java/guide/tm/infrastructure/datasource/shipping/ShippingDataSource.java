package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingRepository;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.shipping.content.ShippingInstructionContent;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
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
            ShippingInstructionContent shippingInstructionContent,
            SingleAllocations singleAllocations,
            BundleAllocations bundleAllocations) {
        UUID shippingNumber = UUID.randomUUID();
        shippingMapper.register(shippingInstructionContent, shippingNumber);

        singleAllocations.list().forEach(allocation ->
                shippingMapper.registerShippedAllocations(shippingNumber, allocation));

        bundleAllocations.list().forEach(allocation ->
                shippingMapper.registerShippedBundleAllocations(shippingNumber, allocation));

        shippingMapper.recordUnshippingSate(shippingNumber);
        return new ShippingNumber(shippingNumber.toString());
    }

    @Override
    public void markShipping(ShippingNumber shippingNumber) {
        shippingMapper.markShipping(shippingNumber);
        shippingMapper.deleteUnshippingState(shippingNumber);
    }

    @Override
    public ShippingInstructionSummaries shippingInstructionSummaries() {
        return new ShippingInstructionSummaries(shippingMapper.shippingInstructions());
    }


}
