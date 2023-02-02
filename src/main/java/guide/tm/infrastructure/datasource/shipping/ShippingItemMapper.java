package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface ShippingItemMapper {

    void register(
            @Param("shippingNumber") ShippingNumber shippingNumber,
            @Param("shippingItemNumber") UUID shippingItemNumber,
            @Param("shippingItem") ShippingItem shippingItem,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("salesOrderItemNumber") SalesOrderItemNumber salesOrderItemNumber);

    List<ShippingItem> shippingItemsOf(
            @Param("shippingNumber") ShippingNumber shippingNumber);
}
