package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.shipping.item.BundleShippingItem;
import guide.tm.domain.model.shipping.item.SingleShippingItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface ShippingItemMapper {

    List<SingleShippingItem> singleShippingItems(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    List<BundleShippingItem> bundleShippingItems(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);
}
