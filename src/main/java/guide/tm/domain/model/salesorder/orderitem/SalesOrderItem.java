package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.Product;

/**
 * 受注明細
 */
public class SalesOrderItem {

    SalesOrderItemNumber salesOrderItemNumber;
    Product product;
    Quantity quantity;

    @Deprecated(since = "for myBatis")
    SalesOrderItem() {

    }

    public SalesOrderItem(Product product, Quantity quantity) {
        this.salesOrderItemNumber = new SalesOrderItemNumber();
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return product.unitPrice().multiply(quantity);
    }

    public SalesOrderItemNumber salesOrderItemNumber() {
        return salesOrderItemNumber;
    }

    public Product product() {
        return product;
    }

    public Quantity quantity() {
        return quantity;
    }
}
