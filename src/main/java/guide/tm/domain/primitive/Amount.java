package guide.tm.domain.primitive;

import guide.tm.domain.model.tax.TaxRate;

import java.math.BigDecimal;

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
     * 税額を計算する
     * 金額 x 税率
     */
    public Amount multiply(TaxRate taxRate) {
        return new Amount(value.multiply(taxRate.decimalValue()));
    }

    public Amount add(Amount other) {
        return new Amount(value.add(other.value));
    }
}
