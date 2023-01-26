package guide.tm.domain.model.primitive;

import java.math.BigDecimal;

/**
 * 金額
 */
public class Amount {
    BigDecimal value;

    public Amount() {
        this(BigDecimal.ZERO);
    }

    Amount(BigDecimal value) {
        this.value = value;
    }

    /**
     * 数量分の金額を計算する
     * 金額 x 数量
     */
    public Amount multiply(Quantity quantity) {
        return new Amount(value.multiply(quantity.decimalValue()));
    }

    /**
     * 率を乗算した金額を計算する
     * 金額 x 税率
     */
    public Amount multiply(Rate rate) {
        return new Amount(value.multiply(rate.value));
    }

    public Amount add(Amount other) {
        return new Amount(value.add(other.value));
    }
}
