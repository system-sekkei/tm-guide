package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.bundle.BundleProduct;

/**
 *  セット商品の受注明細
 */
public class BundleProductOrderItem {
    SalesOrderItemNumber salesOrderItemNumber;
    BundleProductOrderItemContent bundleProductOrderItemContent;

    public BundleProductOrderItem() {
        this(new SalesOrderItemNumber(), new BundleProductOrderItemContent());
    }

    public BundleProductOrderItem(
            SalesOrderItemNumber salesOrderItemNumber,
            BundleProductOrderItemContent bundleProductOrderItemContent) {
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.bundleProductOrderItemContent = bundleProductOrderItemContent;
    }

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return bundleProductOrderItemContent.amountExcludingTax();
    }

    public SalesOrderItemNumber salesOrderItemNumber() {
        return salesOrderItemNumber;
    }

    public BundleProduct product() {
        return bundleProductOrderItemContent.product;
    }

    public Quantity quantity() {
        return bundleProductOrderItemContent.quantity;
    }
}
