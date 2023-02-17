package guide.tm.domain.model.salesorder.orderitem.single;

import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.Quantity;
import jakarta.validation.constraints.AssertTrue;

/**
 * 受注明細の内容
 */
public class SingleOrderItemContent {
    SingleProduct product;
    Quantity quantity;

    public SingleOrderItemContent() {
        this(new SingleProduct(), new Quantity());
    }

    public SingleOrderItemContent(SingleProduct product, Quantity quantity) {
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
