package guide.tm.domain.model.sales;

import guide.tm.domain.model.product.Product;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.Quantity;

/**
 * 受注明細
 */
public class SalesItem {
    Product product;
    Quantity quantity;

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return product.unitPrice().multiply(quantity);
    }
}
