package guide.tm.domain.primitive;

import java.math.BigDecimal;

/**
 * 金額
 */
public class Amount {
    BigDecimal value;

    public Amount(BigDecimal value) {
        this.value = value;
    }

    /**
     * 数量分の金額を計算する
     * 金額 x 数量
     */
    public Amount multiply(Quantity quantity) {
        return new Amount(value.multiply(quantity.decimalValue()));
    }
}
