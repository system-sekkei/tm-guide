package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.allocation.status.bundle.BundleOrderItemStatus;
import guide.tm.domain.model.allocation.status.single.SingleOrderItemStatus;
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
            @Param("singleOrderItemStatus") SingleOrderItemStatus singleOrderItemStatus);

    void registerShippedBundleAllocations(
            @Param("shippingNumber") UUID shippingNumber,
            @Param("bundleOrderItemStatus") BundleOrderItemStatus bundleOrderItemStatus);

}
