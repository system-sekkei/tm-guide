package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.bundle.BundleProduct;
import jakarta.validation.constraints.AssertTrue;

/**
 * セット商品の受注明細の内容
 */
public class BundleProductOrderItemContent {
    BundleProduct product;
    Quantity quantity;

    public BundleProductOrderItemContent() {
        this(new BundleProduct(), new Quantity());
    }

    BundleProductOrderItemContent(BundleProduct product, Quantity quantity) {
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
