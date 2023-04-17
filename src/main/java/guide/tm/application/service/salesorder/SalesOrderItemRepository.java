package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;

public interface SalesOrderItemRepository {
    SingleProductOrderItems singleProductOrderItemsOf(SalesOrderId salesOrderId);

    BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderId salesOrderId);

    void registerSingleProductOrder(SalesOrderId salesOrderId, SalesOrderItemRequest salesOrderItemRequest);

    void registerBundleProductOrder(SalesOrderId salesOrderId, SalesOrderItemRequest salesOrderItemRequest);

    void deleteSingleOrderItem(SalesOrderId salesOrderId, SalesOrderItemNumber salesOrderItemNumber);

    void deleteBundleOrderItem(SalesOrderId salesOrderId, SalesOrderItemNumber salesOrderItemNumber);
}
