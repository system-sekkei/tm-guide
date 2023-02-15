package guide.tm.domain.model.tax.context;

import guide.tm.domain.model.tax.method.SumUpTax;
import guide.tm.domain.model.tax.method.TaxMethod;
import guide.tm.domain.model.tax.method.TotalTax;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.TotalAmount;

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

    public Amount taxOf(TotalAmount totalAmount, TaxRateType taxRateType) {
        return taxMethod.taxOf(totalAmount, taxRateType.rate());
    }
}
