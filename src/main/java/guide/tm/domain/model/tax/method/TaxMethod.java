package guide.tm.domain.model.tax.method;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Rate;
import guide.tm.domain.model.primitive.TotalAmount;

/**
 * 消費税の計算方法
 */
public interface TaxMethod {
    Amount taxOf(TotalAmount totalAmount, Rate rate);
}
