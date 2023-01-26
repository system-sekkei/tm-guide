package guide.tm.domain.model.sales;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.Product;

/**
 * 受注明細
 */
public class SalesOrderItem {
    Product product;
    Quantity quantity;

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return product.unitPrice().multiply(quantity);
    }
}
