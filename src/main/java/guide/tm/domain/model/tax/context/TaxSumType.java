package guide.tm.domain.model.tax.context;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Rate;
import guide.tm.domain.model.primitive.TotalAmount;
import guide.tm.domain.model.tax.method.SumUpTax;
import guide.tm.domain.model.tax.method.TaxMethod;
import guide.tm.domain.model.tax.method.TotalTax;

/**
 * 消費税計算種別
 */
public enum TaxSumType {
    総額計算(new TotalTax()),
    積上計算(new SumUpTax()),
    ;

    TaxMethod taxMethod;

    TaxSumType(TaxMethod taxMethod) {
        this.taxMethod = taxMethod;
    }

    public Amount taxOf(TotalAmount totalAmount, Rate rate) {
        return taxMethod.taxOf(totalAmount, rate);
    }
}
