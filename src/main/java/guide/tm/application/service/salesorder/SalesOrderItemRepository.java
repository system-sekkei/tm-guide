package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;

public interface SalesOrderItemRepository {
    void registerBundleProductOrderItem(SalesOrderNumber salesOrderNumber, SingleOrderItemContent singleOrderItemContent);

    SingleProductOrderItems singleProductOrderItemsOf(SalesOrderNumber salesOrderNumber);

    void registerBundleProductOrderItem(SalesOrderNumber salesOrderNumber, BundleProductOrderItemContent bundleProductOrderItemContent);

    BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber);
}
