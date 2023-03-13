package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSearchCriteria;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.tax.context.TaxSumType;

public interface SalesOrderRepository {
    SalesOrderNumber registerSalesOrder(SalesOrderContent salesOrder);

    SalesOrderContent salesOrderOf(SalesOrderNumber salesOrderNumber);

    SalesOrderSummaries salesOrderSummaries(SalesOrderSearchCriteria salesOrderSearchCriteria);

    void registerTax(TaxSumType taxSumType, SalesOrderNumber salesOrderNumber);

    TaxSumType taxSumTypeOf(SalesOrderNumber salesOrderNumber);
}
