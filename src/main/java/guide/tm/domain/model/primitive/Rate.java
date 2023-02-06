package guide.tm.domain.model.primitive;

import java.math.BigDecimal;

/**
 * 率
 */
public class Rate {
    BigDecimal value;

    public Rate(BigDecimal value) {
        this.value = value;
    }

    @Deprecated Rate() {
    }
}
