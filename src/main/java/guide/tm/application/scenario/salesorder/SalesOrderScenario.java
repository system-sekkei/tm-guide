package guide.tm.application.scenario.salesorder;

import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.domain.model.allocation.content.Allocations;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
import guide.tm.domain.model.shipping.item.ShippingItems;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import guide.tm.domain.model.tax.context.TaxContext;
import org.springframework.stereotype.Service;

/**
 * 受注シナリオ
 */
@Service
public class SalesOrderScenario {
    SalesOrderService salesOrderService;
    SalesOrderItemService salesOrderItemService;
    AllocationService allocationService;
    ShippingItemService shippingItemService;

    SalesOrderScenario(
            SalesOrderService salesOrderService,
            SalesOrderItemService salesOrderItemService,
            AllocationService allocationService,
            ShippingItemService shippingItemService) {
        this.salesOrderService = salesOrderService;
        this.salesOrderItemService = salesOrderItemService;
        this.allocationService = allocationService;
        this.shippingItemService = shippingItemService;
    }

    /**
     * 受注を取得する
     */
    public SalesOrder salesOrderOf(SalesOrderNumber salesOrderNumber) {
        SalesOrderContent salesOrderContent = salesOrderService.salesOrderOf(salesOrderNumber);
        TaxContext taxContext = salesOrderService.taxContextOf(salesOrderNumber);
        SingleProductOrderItems singleProductOrderItems = salesOrderItemService.salesOrderItemsOf(salesOrderNumber);
        BundleProductOrderItems bundleProductOrderItems = salesOrderItemService.bundleProductOrderItemsOf(salesOrderNumber);
        return new SalesOrder(salesOrderContent, taxContext, singleProductOrderItems, bundleProductOrderItems);
    }

    /**
     * 受注の状態を取得する
     */
    public SalesOrderStatus status(SalesOrderNumber salesOrderNumber) {
        SalesOrder salesOrder = salesOrderOf(salesOrderNumber);
        Allocations allocations = allocationService.allocationsOf(salesOrderNumber);
        ShippingItems shippingItems = shippingItemService.shippingItems(salesOrderNumber);
        return new SalesOrderStatus(salesOrderNumber, salesOrder, allocations, shippingItems);
    }

}
