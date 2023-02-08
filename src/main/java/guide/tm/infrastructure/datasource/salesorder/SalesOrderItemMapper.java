package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderItemMapper {

    void register(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("salesOrderItemContent") SalesOrderItemContent salesOrderItemContent);

    List<SalesOrderItem> salesOrderItemsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    void registerBundleProductOrderItem(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("bundleProductOrderItemContent") BundleProductOrderItemContent bundleProductOrderItemContent);

    List<BundleProductOrderItem> bundleProductOrderItemsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);
}
