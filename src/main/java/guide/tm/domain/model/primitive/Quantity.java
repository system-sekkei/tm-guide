package guide.tm.domain.model.primitive;

import java.math.BigDecimal;

/**
 * 数量
 */
public class Quantity {
    int value;

    public Quantity() {
        this(0);
    }

    public Quantity(int value) {
        this.value = value;
    }

    BigDecimal decimalValue() {
        return BigDecimal.valueOf(value);
    }

    public Quantity add(Quantity other) {
        return new Quantity(value + other.value);
    }

    public boolean isGreaterEqualThan(Quantity other) {
        return value >= other.value;
    }

    public Quantity subtract(Quantity other) {
        return new Quantity(value - other.value);
    }

    public boolean isEqual(Quantity other) {
        return value == other.value;
    }
    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
