package guide.tm.domain.model.tax.context;

import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.TotalAmount;
import jakarta.validation.constraints.NotNull;

/**
 * 消費税の状況
 */
public class TaxContext {
    @NotNull(message = "消費税率区分を選択してください")
    TaxRateType taxRateType;
    @NotNull(message = "消費税計算方法を選択してください")
    TaxSumType taxSumType;

    public TaxContext() {
        this(TaxRateType.通常税率, TaxSumType.総額計算);
    }

    public TaxContext(TaxRateType taxRateType, TaxSumType taxSumType) {
        this.taxRateType = taxRateType;
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
        return taxSumType.taxOf(totalAmount, taxRateType);
    }
}
