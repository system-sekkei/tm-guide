package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.individual.IndividualProduct;
import jakarta.validation.constraints.AssertTrue;

/**
 * 受注明細
 */
public class SalesOrderItem {

    SalesOrderItemNumber salesOrderItemNumber;
    IndividualProduct individualProduct;
    Quantity quantity;

    public SalesOrderItem() {
        this(new IndividualProduct(), new Quantity());
    }

    public SalesOrderItem(IndividualProduct individualProduct, Quantity quantity) {
        this.salesOrderItemNumber = new SalesOrderItemNumber();
        this.individualProduct = individualProduct;
        this.quantity = quantity;
    }

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return individualProduct.unitPrice().multiply(quantity);
    }

    public SalesOrderItemNumber salesOrderItemNumber() {
        return salesOrderItemNumber;
    }

    @AssertTrue(message = "1以上の数値を入力してください")
    boolean isQuantitySpecified() {
        return quantity.isGreaterEqualThan(new Quantity(1));
    }

    public IndividualProduct product() {
        return individualProduct;
    }

    public Quantity quantity() {
        return quantity;
    }

}
