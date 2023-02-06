package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.Product;
import jakarta.validation.constraints.AssertTrue;

/**
 * 受注明細
 */
public class SalesOrderItem {

    SalesOrderItemNumber salesOrderItemNumber;
    Product product;
    Quantity quantity;

    public SalesOrderItem() {
        this(new Product(), new Quantity());
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

    @AssertTrue(message = "1以上の数値を入力してください")
    boolean isQuantitySpecified() {
        return quantity.isGreaterEqualThan(new Quantity(1));
    }

    public Product product() {
        return product;
    }

    public Quantity quantity() {
        return quantity;
    }

}
