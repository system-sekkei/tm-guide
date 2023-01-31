package guide.tm.domain.model.tax.method;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Rate;
import guide.tm.domain.model.primitive.TotalAmount;

/**
 * 総額計算での消費税計算
 */
public class TotalTax implements TaxMethod {
    @Override
    public Amount taxOf(TotalAmount totalAmount, Rate rate) {
        return totalAmount.total().multiply(rate);
    }
}