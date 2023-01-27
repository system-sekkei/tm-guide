package guide.tm.domain.model.tax.context;

import guide.tm.domain.model.primitive.Rate;

import java.math.BigDecimal;

/**
 * 消費税率
 */
public class TaxRate {

    Rate rate;

    public TaxRate(BigDecimal percentValue) {
        this.rate = new Rate(percentValue.scaleByPowerOfTen(-2));
    }

}
