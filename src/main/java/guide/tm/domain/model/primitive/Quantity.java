package guide.tm.domain.model.primitive;

import java.math.BigDecimal;

/**
 * 数量
 */
public class Quantity {
    int value;

    Quantity() {
        this(0);
    }

    public Quantity(int value) {
        this.value = value;
    }

    BigDecimal decimalValue() {
        return BigDecimal.valueOf(value);
    }
}
