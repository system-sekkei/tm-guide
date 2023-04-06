package guide.tm.application.scenario.salesorder;

import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.application.service.shipping.ShippingItemService;
import guide.tm.domain.model.allocation.content.Allocations;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.invoice.OrderedYearMonth;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderIdList;
import guide.tm.domain.model.salesorder.order.SalesOrders;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
import guide.tm.domain.model.shipping.item.ShippingItems;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import guide.tm.domain.model.tax.context.TaxSumType;
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
    public SalesOrder salesOrderOf(SalesOrderId salesOrderId) {
        SalesOrderContent salesOrderContent = salesOrderService.salesOrderOf(salesOrderId);
        TaxSumType taxSumType  = salesOrderService.taxSumTypeOf(salesOrderId);
        SingleProductOrderItems singleProductOrderItems = salesOrderItemService.singleProductOrderItemsOf(salesOrderId);
        BundleProductOrderItems bundleProductOrderItems = salesOrderItemService.bundleProductOrderItemsOf(salesOrderId);
        return new SalesOrder(salesOrderId, salesOrderContent, taxSumType, singleProductOrderItems, bundleProductOrderItems);
    }

    /**
     * 請求対象の受注を取得する
     */
    public SalesOrders salesOrdersOf(CustomerId customerId, OrderedYearMonth orderedYearMonth) {
        SalesOrderIdList salesOrderIdList = salesOrderService.salesOrderIdsOf(customerId, orderedYearMonth);
        return new SalesOrders(salesOrderIdList.list().stream().map(this::salesOrderOf).toList());
    }

    /**
     * 受注IDリストの受注を取得する
     */
    public SalesOrders salesOrdersOf(SalesOrderIdList salesOrderIdList) {
        return new SalesOrders(salesOrderIdList.list().stream().map(this::salesOrderOf).toList());
    }


    /**
     * 受注の状態を取得する
     */
    public SalesOrderStatus status(SalesOrderId salesOrderId) {
        SalesOrder salesOrder = salesOrderOf(salesOrderId);
        Allocations allocations = allocationService.allocationsOf(salesOrderId);
        ShippingItems shippingItems = shippingItemService.shippingItems(salesOrderId);
        return new SalesOrderStatus(salesOrderId, salesOrder, allocations, shippingItems);
    }

}
