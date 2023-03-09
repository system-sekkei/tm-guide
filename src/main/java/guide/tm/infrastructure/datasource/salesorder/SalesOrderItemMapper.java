package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderItemMapper {

    List<SingleOrderItem> salesOrderItemsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    List<BundleProductOrderItem> bundleProductOrderItemsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    void registerSingleProductOrder(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("salesOrderItemRequest") SalesOrderItemRequest salesOrderItemRequest);

    void registerBundleProductOrder(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("salesOrderItemRequest") SalesOrderItemRequest salesOrderItemRequest);
}
