package guide.tm.domain.primitive;

import java.math.BigDecimal;

/**
 * 数量
 */
public class Quantity {
    int value;

    BigDecimal decimalValue() {
        return BigDecimal.valueOf(value);
    }
}
