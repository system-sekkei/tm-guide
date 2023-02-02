package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import guide.tm.domain.model.tax.context.TaxContext;

/**
 * 受注
 */
public class SalesOrder {
    SalesOrderContent salesOrderContent;
    TaxContext taxContext;
    SalesOrderItems salesOrderItems;

    public SalesOrder(SalesOrderContent salesOrderContent, TaxContext taxContext, SalesOrderItems salesOrderItems) {
        this.salesOrderContent = salesOrderContent;
        this.taxContext = taxContext;
        this.salesOrderItems = salesOrderItems;
    }
}
