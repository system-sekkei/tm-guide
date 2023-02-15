package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
interface ShippingMapper {

    void register(
            @Param("shipping") Shipping shipping,
            @Param("shippingNumber") UUID shippingNumber);

    Shipping shippingOf(@Param("shippingNumber") ShippingNumber shippingNumber);

    void registerShippingItem(
            @Param("shippingNumber") ShippingNumber shippingNumber,
            @Param("shippingItemNumber") UUID shippingItemNumber,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("shippingItem") ShippingItem shippingItem);

//    void registerShippedAllocations(
//            @Param("shippingNumber") UUID shippingNumber,
//            @Param("allocation") Allocation allocation);
//
//    void registerShippedBundleAllocations(
//            @Param("shippingNumber") UUID shippingNumber,
//            @Param("allocation") BundleAllocation allocation);
}
