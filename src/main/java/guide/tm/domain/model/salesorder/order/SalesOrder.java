package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.primitive.Amount;
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

    /**
     * 税抜き金額
     */
    public Amount amountExcludingTax() {
        return salesOrderItems.amountExcludingTax();
    }

    /**
     * 税込金額
     */
    public Amount amountIncludingTax() {
        return salesOrderItems.amountIncludingTax(taxContext);
    }

    /**
     * 税額
     */
    public Amount taxOf() {
        return salesOrderItems.taxOf(taxContext);
    }

    public SalesOrderContent salesOrderContent() {
        return salesOrderContent;
    }

    public TaxContext taxContext() {
        return taxContext;
    }

    public SalesOrderItems salesOrderItems() {
        return salesOrderItems;
    }
}
