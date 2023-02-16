package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.allocation.bundle.BundleAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.shipping.content.Shipping;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
interface ShippingMapper {

    void register(
            @Param("shipping") Shipping shipping,
            @Param("shippingNumber") UUID shippingNumber);

    void registerShippedAllocations(
            @Param("shippingNumber") UUID shippingNumber,
            @Param("singleAllocation") SingleAllocation singleAllocation);

    void registerShippedBundleAllocations(
            @Param("shippingNumber") UUID shippingNumber,
            @Param("bundleAllocation") BundleAllocation bundleAllocation);

}
