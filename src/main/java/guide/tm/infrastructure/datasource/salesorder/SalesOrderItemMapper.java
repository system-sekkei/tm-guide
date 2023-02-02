package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderItemMapper {

    void register(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("saleOrderItemNumber") UUID saleOrderItemNumber,
            @Param("salesOrderItem") SalesOrderItem salesOrderItem);

    List<SalesOrderItem> salesOrderItemsOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);
}
