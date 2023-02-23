package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.shipping.content.ShippingInstructionContent;
import guide.tm.domain.model.shipping.content.ShippingInstructionSummary;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface ShippingMapper {

    void register(
            @Param("shipping") ShippingInstructionContent shippingInstructionContent,
            @Param("shippingNumber") UUID shippingNumber);

    void registerShippedAllocations(
            @Param("shippingNumber") UUID shippingNumber,
            @Param("singleAllocation") SingleAllocation singleAllocation);

    void registerShippedBundleAllocations(
            @Param("shippingNumber") UUID shippingNumber,
            @Param("bundleAllocation") BundleAllocation bundleAllocation);

    void markShipping(
            @Param("shippingNumber") ShippingNumber shippingNumber);

    List<ShippingInstructionSummary> shippingInstructions();

    void recordUnshippingSate(
            @Param("shippingNumber") UUID shippingNumber);

    void deleteUnshippingState(
            @Param("shippingNumber") ShippingNumber shippingNumber);
}
