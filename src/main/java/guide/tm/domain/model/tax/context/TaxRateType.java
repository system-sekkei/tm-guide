package guide.tm.domain.model.tax.context;

import guide.tm.domain.primitive.Rate;

import java.math.BigDecimal;

/**
 * 消費税率区分
 */
public enum TaxRateType {
    軽減税率(8),
    通常税率(10),
    ;

    int percent;

    TaxRateType(int percent) {
        this.percent = percent;
    }

    public Rate rate() {
        return new Rate(new BigDecimal(percent).scaleByPowerOfTen(-2));
    }
}
