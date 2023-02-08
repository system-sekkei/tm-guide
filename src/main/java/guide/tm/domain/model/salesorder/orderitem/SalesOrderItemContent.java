package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.individual.IndividualProduct;
import jakarta.validation.constraints.AssertTrue;

/**
 * 受注明細の内容
 */
public class SalesOrderItemContent {
    IndividualProduct product;
    Quantity quantity;

    SalesOrderItemContent() {
        this(new IndividualProduct(), new Quantity());
    }

    SalesOrderItemContent(IndividualProduct product, Quantity quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return product.unitPrice().multiply(quantity);
    }

    @AssertTrue(message = "1以上の数値を入力してください")
    boolean isQuantitySpecified() {
        return quantity.isGreaterEqualThan(new Quantity(1));
    }

}
