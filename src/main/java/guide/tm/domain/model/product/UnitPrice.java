package guide.tm.domain.model.product;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;

import java.math.BigDecimal;

/**
 * 商品単価
 */
public class UnitPrice {
    Amount amount;

    UnitPrice() {
        this(new Amount());
    }

    public UnitPrice(int price) {
        this(new Amount(BigDecimal.valueOf(price)));
    }

    public UnitPrice(Amount amount) {
        this.amount = amount;
    }

    public Amount multiply(Quantity quantity) {
        return amount.multiply(quantity);
    }

    @Override
    public String toString() {
        return amount.toString();
    }
}
