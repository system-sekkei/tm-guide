package guide.tm.domain.model.tax;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.TotalAmount;

/**
 * 消費税の状況
 */
public class TaxContext {
    TaxRate taxRate;
    TaxSumType taxSumType;

    /**
     * 消費税の適用条件に合わせて、税額を算出する
     */
    public Amount includingTaxOf(TotalAmount totalAmount) {
        if (taxSumType.is総額計算()) {
            return totalAmount.total().multiply(taxRate.rate());
        }
        return totalAmount.totalOfEach(taxRate.rate);
    }
}
