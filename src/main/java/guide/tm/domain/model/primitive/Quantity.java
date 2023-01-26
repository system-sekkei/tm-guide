package guide.tm.domain.model.primitive;

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
