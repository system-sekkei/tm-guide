package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.SalesOrder;
import guide.tm.domain.model.salesorder.SalesOrderNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
interface SalesOrderMapper {

    void registerSalesOrder(
            @Param("salesOrderNumber") UUID salesOrderNumber,
            @Param("salesOrder") SalesOrder salesOrder);

    SalesOrder salesOrderOf(@Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);
}
