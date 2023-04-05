package guide.tm.application.service.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.summary.ShippingInstructionCriteria;

public interface ShippingInstructionRepository {

    ShippingInstructionSummaries shippingInstructionSummaries(ShippingInstructionCriteria shippingInstructionCriteria);

    ShippingNumber register(ShippingInstruction shippingInstruction);

    void markAsInstructed(SalesOrderId salesOrderId);
}
