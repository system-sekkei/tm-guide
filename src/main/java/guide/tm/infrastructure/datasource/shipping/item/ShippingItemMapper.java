package guide.tm.infrastructure.datasource.shipping.item;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.shipping.bundle.BundleShippingItem;
import guide.tm.domain.model.shipping.single.SingleShippingItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface ShippingItemMapper {

    List<SingleShippingItem> singleShippingItems(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    List<BundleShippingItem> bundleShippingItems(
            @Param("salesOrderId") SalesOrderId salesOrderId);
}
