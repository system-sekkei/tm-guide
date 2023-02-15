package guide.tm.domain.model.tax.method;

import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.Rate;
import guide.tm.domain.primitive.TotalAmount;

/**
 * 消費税の計算方法
 */
public interface TaxMethod {
    Amount taxOf(TotalAmount totalAmount, Rate rate);
}
