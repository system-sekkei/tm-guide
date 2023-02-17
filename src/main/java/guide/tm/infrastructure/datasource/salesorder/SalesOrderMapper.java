package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummary;
import guide.tm.domain.model.tax.context.TaxContext;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderMapper {

    void registerSalesOrder(
            @Param("salesOrderNumber") UUID salesOrderNumber,
            @Param("salesOrder") SalesOrderContent salesOrder);

    SalesOrderContent salesOrderOf(@Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    List<SalesOrderSummary> salesOrderSummaries();

    TaxContext taxContextOf(
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

    void registerTax(
            @Param("taxContext") TaxContext taxContext,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber);

}
