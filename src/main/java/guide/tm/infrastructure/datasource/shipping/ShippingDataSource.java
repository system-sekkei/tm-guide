package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingRepository;
import guide.tm.domain.model.shipping.content.ShippingInstruction;
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
    public ShippingNumber register(ShippingInstruction shippingInstruction) {
        UUID shippingNumber = UUID.randomUUID();
        shippingMapper.register(shippingInstruction.shippingInstructionContent(), shippingNumber);

        shippingInstruction.singleAllocations().list().forEach(allocation ->
                shippingMapper.registerShippedAllocations(shippingNumber, allocation));

        shippingInstruction.bundleAllocations().list().forEach(allocation ->
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
