package guide.tm.domain.model.tax.context;

import guide.tm.domain.model.primitive.Rate;

/**
 * 消費税率
 */
public class TaxRate {

    Rate rate;

    public Rate rate() {
        return rate;
    }

    public Rate includingTaxRate() {
        return Rate.ONE.add(rate);
    }
}
