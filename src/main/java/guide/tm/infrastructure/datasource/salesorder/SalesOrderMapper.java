package guide.tm.infrastructure.datasource.salesorder;

import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.salesorder.content.OrderedDate;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSearchCriteria;
import guide.tm.domain.model.salesorder.order.SalesOrderSummary;
import guide.tm.domain.model.tax.context.TaxSumType;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.UUID;

@Mapper
interface SalesOrderMapper {

    void registerSalesOrder(
            @Param("salesOrderId") UUID salesOrderId,
            @Param("salesOrderNumber") SalesOrderNumber salesOrderNumber,
            @Param("salesOrder") SalesOrderContent salesOrder);

    SalesOrderContent salesOrderOf(@Param("salesOrderId") SalesOrderId salesOrderId);

    List<SalesOrderSummary> salesOrderSummaries(
            @Param("salesOrderSearchCriteria") SalesOrderSearchCriteria salesOrderSearchCriteria);

    TaxSumType taxSumTypeOf(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    void registerTax(
            @Param("taxSumType") TaxSumType taxSumType,
            @Param("salesOrderId") SalesOrderId salesOrderId);

    long newSaleOrderNumber();

    List<SalesOrderId> salesOrderIdsOf(
            @Param("customerId") CustomerId customerId,
            @Param("startOfOrderedMonth") OrderedDate startOfOrderedMonth,
            @Param("endOfOrderedMonth") OrderedDate endOfOrderedMonth);

    void markAsOrdered(
            @Param("salesOrderId") SalesOrderId salesOrderId);

    SalesOrderId completedOrderOf(@Param("salesOrderId") SalesOrderId salesOrderId);
}
