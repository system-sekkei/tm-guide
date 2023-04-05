package guide.tm.infrastructure.datasource.shipping.instruction;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.content.ShippingInstructionContent;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummary;
import guide.tm.domain.model.shipping.summary.ShippingInstructionCriteria;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface ShippingInstructionMapper {

    void register(
            @Param("shipping") ShippingInstructionContent shippingInstructionContent,
            @Param("shippingNumber") UUID shippingNumber);

    void registerShippedAllocations(
            @Param("shippingNumber") UUID shippingNumber,
            @Param("singleAllocation") SingleAllocation singleAllocation);

    void registerShippedBundleAllocations(
            @Param("shippingNumber") UUID shippingNumber,
            @Param("bundleAllocation") BundleAllocation bundleAllocation);

    void recordUnshippingSate(
            @Param("shippingNumber") UUID shippingNumber);

    void markAsInstructed(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    List<ShippingInstructionSummary> searchInstructed(
            @Param("shippingInstructionCriteria") ShippingInstructionCriteria shippingInstructionCriteria);

    List<ShippingInstructionSummary> searchNotInstructed(
            @Param("instructedSalesOrderIds") List<SalesOrderId> instructedSalesOrderIds,
            @Param("shippingInstructionCriteria") ShippingInstructionCriteria shippingInstructionCriteria);
}
