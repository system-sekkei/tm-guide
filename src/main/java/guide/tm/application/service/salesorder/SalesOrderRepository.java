package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;
import guide.tm.domain.model.tax.context.TaxContext;

public interface SalesOrderRepository {
    SalesOrderNumber registerSalesOrder(SalesOrderContent salesOrder);

    SalesOrderContent salesOrderOf(SalesOrderNumber salesOrderNumber);

    SalesOrderSummaries salesOrderSummaries();

    TaxContext taxContextOf(SalesOrderNumber salesOrderNumber);

    void registerTax(TaxContext taxContext, SalesOrderNumber salesOrderNumber);
}
