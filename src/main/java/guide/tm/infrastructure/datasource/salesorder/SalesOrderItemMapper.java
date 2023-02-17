package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderItemMapper {

    void register(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("singleOrderItemContent") SingleOrderItemContent singleOrderItemContent);

    List<SingleOrderItem> salesOrderItemsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    void registerBundleProductOrderItem(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("bundleProductOrderItemContent") BundleProductOrderItemContent bundleProductOrderItemContent);

    List<BundleProductOrderItem> bundleProductOrderItemsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);
}
