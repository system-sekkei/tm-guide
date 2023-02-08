package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.individual.IndividualProduct;

/**
 * 受注明細
 */
public class SalesOrderItem {

    SalesOrderItemNumber salesOrderItemNumber;
    SalesOrderItemContent salesOrderItemContent;

    public SalesOrderItem() {
        this(new SalesOrderItemNumber(), new SalesOrderItemContent());
    }

    public SalesOrderItem(SalesOrderItemNumber salesOrderItemNumber, SalesOrderItemContent salesOrderItemContent) {
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.salesOrderItemContent = salesOrderItemContent;
    }

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return salesOrderItemContent.amountExcludingTax();
    }

    public SalesOrderItemNumber salesOrderItemNumber() {
        return salesOrderItemNumber;
    }

    public IndividualProduct product() {
        return salesOrderItemContent.product;
    }

    public Quantity quantity() {
        return salesOrderItemContent.quantity;
    }
}
