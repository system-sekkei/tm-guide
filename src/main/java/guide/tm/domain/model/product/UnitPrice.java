package guide.tm.domain.model.product;

import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.Quantity;

import java.math.BigDecimal;

/**
 * 商品単価
 */
public class UnitPrice {
    Amount value;

    public Amount multiply(Quantity quantity) {
        return value.multiply(quantity);
    }
}
