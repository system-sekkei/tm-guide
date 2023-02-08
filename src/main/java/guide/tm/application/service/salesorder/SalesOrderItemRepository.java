package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;

public interface SalesOrderItemRepository {
    void register(SalesOrderNumber salesOrderNumber, SalesOrderItemContent salesOrderItemContent);

    SalesOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber);
}
