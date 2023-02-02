package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

public interface SalesOrderRepository {
    SalesOrderNumber registerSalesOrder(SalesOrder salesOrder);

    SalesOrder salesOrderOf(SalesOrderNumber salesOrderNumber);
}
