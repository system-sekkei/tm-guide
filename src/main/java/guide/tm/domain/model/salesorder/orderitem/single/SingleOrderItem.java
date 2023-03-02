package guide.tm.domain.model.salesorder.orderitem.single;

import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.Quantity;

/**
 * 受注明細
 */
public class SingleOrderItem {

    SalesOrderItemNumber salesOrderItemNumber;
    SingleOrderItemContent singleOrderItemContent;

    public SingleOrderItem() {
        this(new SalesOrderItemNumber(), new SingleOrderItemContent());
    }

    public SingleOrderItem(SalesOrderItemNumber salesOrderItemNumber, SingleOrderItemContent singleOrderItemContent) {
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.singleOrderItemContent = singleOrderItemContent;
    }

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return singleOrderItemContent.amountExcludingTax();
    }

    public SalesOrderItemNumber salesOrderItemNumber() {
        return salesOrderItemNumber;
    }

    public SingleProduct product() {
        return singleOrderItemContent.product;
    }

    public Quantity quantity() {
        return singleOrderItemContent.quantity;
    }

    public boolean isSame(SingleOrderItem singleOrderItem) {
        return salesOrderItemNumber.isSame(singleOrderItem.salesOrderItemNumber);
    }

    public boolean isReducedTaxRateItem() {
        return singleOrderItemContent.isReducedTaxRateItem();
    }

    public boolean isNormalTaxRateItem() {
        return singleOrderItemContent.isNormalTaxRateItem();
    }

    public SingleOrderItemContent singleOrderItemContent() {
        return singleOrderItemContent;
    }
}
