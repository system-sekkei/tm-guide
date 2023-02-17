package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.content.ShippingFee;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.primitive.Amount;

/**
 * 受注
 */
public class SalesOrder {
    SalesOrderContent salesOrderContent;
    TaxContext taxContext;
    SingleProductOrderItems singleProductOrderItems;
    BundleProductOrderItems bundleProductOrderItems;

    public SalesOrder(
            SalesOrderContent salesOrderContent,
            TaxContext taxContext,
            SingleProductOrderItems singleProductOrderItems,
            BundleProductOrderItems bundleProductOrderItems) {
        this.salesOrderContent = salesOrderContent;
        this.taxContext = taxContext;
        this.singleProductOrderItems = singleProductOrderItems;
        this.bundleProductOrderItems = bundleProductOrderItems;
    }

    /**
     * 税抜き金額
     */
    public Amount amountExcludingTax() {
        Amount individualAmount = singleProductOrderItems.amountExcludingTax();
        Amount bundleAmount = bundleProductOrderItems.amountExcludingTax();
        return individualAmount.add(bundleAmount);
    }

    /**
     * 税込金額
     */
    public Amount amountIncludingTax() {
        Amount individualAmount = singleProductOrderItems.amountIncludingTax(taxContext);
        Amount bundleAmount = bundleProductOrderItems.amountIncludingTax(taxContext);
        return individualAmount.add(bundleAmount);
    }

    /**
     * 税額
     */
    public Amount tax() {
        Amount individualAmount = singleProductOrderItems.taxOf(taxContext);
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

    public SingleProductOrderItems singleProductOrderItems() {
        return singleProductOrderItems;
    }

    public BundleProductOrderItems bundleProductOrderItems() {
        return bundleProductOrderItems;
    }
}
