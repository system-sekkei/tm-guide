package guide.tm.domain.primitive;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * 金額
 */
public class Amount {
    BigDecimal value;

    public Amount() {
        this(BigDecimal.ZERO);
    }

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

    /**
     * 率を乗算した金額を計算する
     * 金額 x 税率
     * 1円未満は切り捨て
     */
    public Amount multiply(Rate rate) {
        return new Amount(value.multiply(rate.value).setScale(0, RoundingMode.DOWN));
    }

    public Amount add(Amount other) {
        return new Amount(value.add(other.value));
    }

    @Override
    public String toString() {
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        return decimalFormat.format(value);
//        return value.stripTrailingZeros().toPlainString();
    }

    public boolean isGreaterThan(Amount other) {
        return value.compareTo(other.value) > 0;
    }
}
