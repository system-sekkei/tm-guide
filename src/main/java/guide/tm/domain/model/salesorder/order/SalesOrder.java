package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItems;
import guide.tm.domain.model.tax.context.TaxContext;

/**
 * 受注
 */
public class SalesOrder {
    SalesOrderContent salesOrderContent;
    TaxContext taxContext;
    SalesOrderItems salesOrderItems;
    BundleProductOrderItems bundleProductOrderItems;

    public SalesOrder(
            SalesOrderContent salesOrderContent,
            TaxContext taxContext,
            SalesOrderItems salesOrderItems,
            BundleProductOrderItems bundleProductOrderItems) {
        this.salesOrderContent = salesOrderContent;
        this.taxContext = taxContext;
        this.salesOrderItems = salesOrderItems;
        this.bundleProductOrderItems = bundleProductOrderItems;
    }

    /**
     * 税抜き金額
     */
    public Amount amountExcludingTax() {
        Amount individualAmount = salesOrderItems.amountExcludingTax();
        Amount bundleAmount = bundleProductOrderItems.amountExcludingTax();
        return individualAmount.add(bundleAmount);
    }

    /**
     * 税込金額
     */
    public Amount amountIncludingTax() {
        Amount individualAmount = salesOrderItems.amountIncludingTax(taxContext);
        Amount bundleAmount = bundleProductOrderItems.amountIncludingTax(taxContext);
        return individualAmount.add(bundleAmount);
    }

    /**
     * 税額
     */
    public Amount tax() {
        Amount individualAmount = salesOrderItems.taxOf(taxContext);
        Amount bundleAmount = bundleProductOrderItems.taxOf(taxContext);
        return individualAmount.add(bundleAmount);
    }

    /**
     * 送料
     */
    public ShippingFee shippingFee() {
        return new ShippingFee(amountExcludingTax());
    }

    /**
     * 合計金額
     */
    public Amount totalAmount() {
        return amountIncludingTax().add(shippingFee().amount());
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

    public BundleProductOrderItems bundleProductOrderItems() {
        return bundleProductOrderItems;
    }
}
