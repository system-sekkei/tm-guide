package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderMapper {

    void registerSalesOrder(
            @Param("salesOrderNumber") UUID salesOrderNumber,
            @Param("salesOrder") SalesOrder salesOrder);

    SalesOrder salesOrderOf(@Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    List<SalesOrder> salesOrders();
}
