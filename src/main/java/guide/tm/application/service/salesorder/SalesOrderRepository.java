package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.SalesOrder;
import guide.tm.domain.model.salesorder.SalesOrderNumber;

public interface SalesOrderRepository {
    SalesOrderNumber registerSalesOrder(SalesOrder salesOrder);

    SalesOrder salesOrderOf(SalesOrderNumber salesOrderNumber);
}
