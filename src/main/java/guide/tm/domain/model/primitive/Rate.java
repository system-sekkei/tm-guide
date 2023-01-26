package guide.tm.domain.model.primitive;

import java.math.BigDecimal;

/**
 * 率
 */
public class Rate {
    BigDecimal value;

    public static final Rate ONE = new Rate(BigDecimal.ONE);

    Rate(BigDecimal value) {
        this.value = value;
    }

    public Rate add(Rate other) {
        return new Rate(value.add(other.value));
    }

}
