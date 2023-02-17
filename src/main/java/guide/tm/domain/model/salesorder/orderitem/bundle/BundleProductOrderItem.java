package guide.tm.domain.model.salesorder.orderitem.bundle;

import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.Quantity;

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

    public BundleProduct bundleProduct() {
        return bundleProductOrderItemContent.product;
    }

    public Quantity quantity() {
        return bundleProductOrderItemContent.quantity;
    }

    public BundleProductOrderItemContent bundleProductOrderItemContent() {
        return bundleProductOrderItemContent;
    }

    public boolean isSame(BundleProductOrderItem bundleProductOrderItem) {
        return salesOrderItemNumber.isSame(bundleProductOrderItem.salesOrderItemNumber);
    }
}
