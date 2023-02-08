package guide.tm.application.scenario.salesorder;

import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.order.SalesOrder;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import guide.tm.domain.model.tax.context.TaxContext;
import org.springframework.stereotype.Service;

/**
 * 受注シナリオ
 */
@Service
public class SalesOrderScenario {
    SalesOrderService salesOrderService;
    SalesOrderItemService salesOrderItemService;

    SalesOrderScenario(
            SalesOrderService salesOrderService, SalesOrderItemService salesOrderItemService) {
        this.salesOrderService = salesOrderService;
        this.salesOrderItemService = salesOrderItemService;
    }

    /**
     * 受注を取得する
     */
    public SalesOrder salesOrderOf(SalesOrderNumber salesOrderNumber) {
        SalesOrderContent salesOrderContent = salesOrderService.salesOrderOf(salesOrderNumber);
        TaxContext taxContext = salesOrderService.taxContextOf(salesOrderNumber);
        SalesOrderItems salesOrderItems = salesOrderItemService.salesOrderItemsOf(salesOrderNumber);
        BundleProductOrderItems bundleProductOrderItems = salesOrderItemService.bundleProductOrderItemsOf(salesOrderNumber);
        return new SalesOrder(salesOrderContent, taxContext, salesOrderItems, bundleProductOrderItems);
    }
}
