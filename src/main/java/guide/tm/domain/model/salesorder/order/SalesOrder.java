package guide.tm.domain.model.salesorder.order;

import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.content.ShippingFee;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
import guide.tm.domain.model.tax.context.TaxSumType;
import guide.tm.domain.primitive.Amount;

/**
 * 受注
 */
public class SalesOrder {
    SalesOrderId salesOrderId;
    SalesOrderContent salesOrderContent;
    TaxSumType taxSumType;
    SingleProductOrderItems singleProductOrderItems;
    BundleProductOrderItems bundleProductOrderItems;
    SalesOrderedType salesOrderedType;

    public SalesOrder(
            SalesOrderId salesOrderId,
            SalesOrderContent salesOrderContent,
            TaxSumType taxSumType,
            SingleProductOrderItems singleProductOrderItems,
            BundleProductOrderItems bundleProductOrderItems,
            SalesOrderedType salesOrderedType) {
        this.salesOrderId = salesOrderId;
        this.salesOrderContent = salesOrderContent;
        this.taxSumType = taxSumType;
        this.singleProductOrderItems = singleProductOrderItems;
        this.bundleProductOrderItems = bundleProductOrderItems;
        this.salesOrderedType = salesOrderedType;
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
        Amount individualAmount = singleProductOrderItems.amountIncludingTax(taxSumType);
        Amount bundleAmount = bundleProductOrderItems.amountIncludingTax(taxSumType);
        return individualAmount.add(bundleAmount);
    }

    /**
     * 税額
     */
    public Amount tax() {
        Amount individualAmount = singleProductOrderItems.taxOf(taxSumType);
        Amount bundleAmount = bundleProductOrderItems.taxOf(taxSumType);
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

    public SalesOrderId salesOrderId() {
        return salesOrderId;
    }

    public SalesOrderContent salesOrderContent() {
        return salesOrderContent;
    }

    public TaxSumType taxSumType() {
        return taxSumType;
    }

    public SingleProductOrderItems singleProductOrderItems() {
        return singleProductOrderItems;
    }

    public BundleProductOrderItems bundleProductOrderItems() {
        return bundleProductOrderItems;
    }

    public SalesOrderedType salesOrderedType() {
        return salesOrderedType;
    }

    public boolean hasItems() {
        return !singleProductOrderItems.isEmpty() || !bundleProductOrderItems.isEmpty();
    }
}
