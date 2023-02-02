package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;

public interface SalesOrderItemRepository {
    void register(SalesOrderNumber salesOrderNumber, SalesOrderItem salesOrderItem);

    SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber);
}
