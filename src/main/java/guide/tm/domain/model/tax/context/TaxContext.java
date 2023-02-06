package guide.tm.domain.model.tax.context;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.TotalAmount;

/**
 * 消費税の状況
 */
public class TaxContext {
    TaxRate taxRate;
    TaxSumType taxSumType;

    @Deprecated TaxContext() {
    }

    public TaxContext(TaxRate taxRate, TaxSumType taxSumType) {
        this.taxRate = taxRate;
        this.taxSumType = taxSumType;
    }

    /**
     * 消費税の適用条件に合わせて、税込み総額を算出する
     */
    public Amount includingTaxOf(TotalAmount totalAmount) {
        return totalAmount.total().add(taxOf(totalAmount));
    }

    /**
     * 消費税の適用条件に合わせて、税額を算出する
     */
    public Amount taxOf(TotalAmount totalAmount) {
        return taxSumType.taxOf(totalAmount, taxRate.rate);
    }
}
