package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;

public interface SalesOrderItemRepository {
    SingleProductOrderItems singleProductOrderItemsOf(SalesOrderNumber salesOrderNumber);

    BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber);

    void registerSingleProductOrder(SalesOrderNumber salesOrderNumber, SalesOrderItemRequest salesOrderItemRequest);

    void registerBundleProductOrder(SalesOrderNumber salesOrderNumber, SalesOrderItemRequest salesOrderItemRequest);
}
