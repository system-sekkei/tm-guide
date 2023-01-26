package guide.tm.domain.model.product;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;

/**
 * 商品単価
 */
public class UnitPrice {
    Amount value;

    public Amount multiply(Quantity quantity) {
        return value.multiply(quantity);
    }
}
