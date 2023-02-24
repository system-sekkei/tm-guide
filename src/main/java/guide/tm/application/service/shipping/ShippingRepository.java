package guide.tm.application.service.shipping;

import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingNumber;

public interface ShippingRepository {
    void markShipping(ShippingNumber shippingNumber);

    ShippingInstructionSummaries shippingInstructionSummaries();

    ShippingNumber register(ShippingInstruction shippingInstruction);
}
