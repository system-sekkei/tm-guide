package guide.tm.infrastructure.datasource.shipping;

import guide.tm.application.service.shipping.ShippingRepository;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummaries;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummary;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.summary.ShippingInstructionCriteria;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ShippingDataSource implements ShippingRepository {

    ShippingInstructionMapper shippingInstructionMapper;

    ShippingDataSource(ShippingInstructionMapper shippingInstructionMapper) {
        this.shippingInstructionMapper = shippingInstructionMapper;
    }

    @Override
    public ShippingNumber register(ShippingInstruction shippingInstruction) {
        UUID shippingNumber = UUID.randomUUID();
        shippingInstructionMapper.register(shippingInstruction.shippingInstructionContent(), shippingNumber);

        shippingInstruction.singleAllocations().list().forEach(allocation ->
                shippingInstructionMapper.registerShippedAllocations(shippingNumber, allocation));

        shippingInstruction.bundleAllocations().list().forEach(allocation ->
                shippingInstructionMapper.registerShippedBundleAllocations(shippingNumber, allocation));

        shippingInstructionMapper.recordUnshippingSate(shippingNumber);
        return new ShippingNumber(shippingNumber.toString());
    }

    @Override
    public void markAsInstructed(SalesOrderId salesOrderId) {
        shippingInstructionMapper.markAsInstructed(salesOrderId);
    }

    @Override
    public void markShipping(ShippingNumber shippingNumber) {
        shippingInstructionMapper.markShipping(shippingNumber);
        shippingInstructionMapper.deleteUnshippingState(shippingNumber);
    }

    @Override
    public ShippingInstructionSummaries shippingInstructionSummaries(ShippingInstructionCriteria shippingInstructionCriteria) {
        List<ShippingInstructionSummary> result = new ArrayList<>();
        List<ShippingInstructionSummary> instructed = shippingInstructionMapper.searchInstructed(shippingInstructionCriteria);

        if (shippingInstructionCriteria.containsInstructed()) {
            result.addAll(instructed);
        }

        if (shippingInstructionCriteria.containsNotInstructed()) {
            List<SalesOrderId> instructedSalesOrderIds = instructed.stream().map(ShippingInstructionSummary::salesOrderId).toList();
            List<ShippingInstructionSummary> notInstructed = shippingInstructionMapper.searchNotInstructed(instructedSalesOrderIds, shippingInstructionCriteria);
            result.addAll(notInstructed);
        }

        return new ShippingInstructionSummaries(result);
    }

}
