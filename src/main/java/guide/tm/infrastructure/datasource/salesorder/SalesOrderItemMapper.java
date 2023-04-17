package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderItemMapper {

    List<SingleOrderItem> salesOrderItemsOf(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    List<BundleProductOrderItem> bundleProductOrderItemsOf(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    void registerSingleProductOrder(
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("salesOrderItemRequest") SalesOrderItemRequest salesOrderItemRequest);

    void registerBundleProductOrder(
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("salesOrderItemRequest") SalesOrderItemRequest salesOrderItemRequest);

    void registerActiveSingleProductOrder(
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber);

    void registerActiveBundleProductOrder(
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber);

    void deleteSingleOrderItem(
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("salesOrderItemNumber") SalesOrderItemNumber salesOrderItemNumber);

    void deleteBundleOrderItem(
            @Param("salesOrderId") SalesOrderId salesOrderId,
            @Param("salesOrderItemNumber") SalesOrderItemNumber salesOrderItemNumber);
}
