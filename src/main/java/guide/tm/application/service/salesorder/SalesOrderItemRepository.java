package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.SalesOrderItem;
import guide.tm.domain.model.salesorder.SalesOrderItems;
import guide.tm.domain.model.salesorder.SalesOrderNumber;

public interface SalesOrderItemRepository {
    void register(SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem);

    SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber);
}
