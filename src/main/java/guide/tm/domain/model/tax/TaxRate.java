package guide.tm.domain.model.tax;

import java.math.BigDecimal;

/**
 * 消費税率
 */
public class TaxRate {
    BigDecimal value;

    public BigDecimal decimalValue() {
        return value;
    }
}
