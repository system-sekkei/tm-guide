package guide.tm.application.service.salesorder;

import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.SingleProductOrderItems;

public interface SalesOrderItemRepository {
    void registerBundleProductOrderItem(SalesOrderNumber salesOrderNumber, SalesOrderItemContent salesOrderItemContent);

    SingleProductOrderItems salesOrderItemsOf(SalesOrderNumber salesOrderNumber);

    void registerBundleProductOrderItem(SalesOrderNumber salesOrderNumber, BundleProductOrderItemContent bundleProductOrderItemContent);

    BundleProductOrderItems bundleProductOrderItemsOf(SalesOrderNumber salesOrderNumber);
}
