package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.order.SalesOrderSummaries;

public interface SalesOrderRepository {
    SalesOrderNumber registerSalesOrder(SalesOrderContent salesOrder);

    SalesOrderContent salesOrderOf(SalesOrderNumber salesOrderNumber);

    SalesOrderSummaries salesOrderSummaries();
}
