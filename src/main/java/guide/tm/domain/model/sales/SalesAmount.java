package guide.tm.domain.model.sales;

import guide.tm.domain.model.tax.TaxContext;
import guide.tm.domain.model.tax.TaxRate;
import guide.tm.domain.primitive.Amount;

import java.util.Set;

/**
 * 受注金額
 */
public class SalesAmount {
    Set<Amount> set;

    public SalesAmount(Set<Amount> set) {
        this.set = set;
    }

    /**
     * 合計金額
     */
    public Amount total() {
        return set.stream().reduce(Amount::add).orElse(new Amount());
    }

    /**
     * 消費税の適用条件に合わせて、税額を算出する
     */
    public Amount total(TaxContext taxContext) {
        if (taxContext.salesTaxType().is総額計算()) {
            return total().multiply(taxContext.taxRate());
        }
        return set.stream()
                .map(amount -> amount.multiply(taxContext.taxRate()))
                .reduce(Amount::add).orElse(new Amount());
    }

    public Amount totalOfEach(TaxRate taxRate) {
        return set.stream()
                .map(amount -> amount.multiply(taxRate))
                .reduce(Amount::add).orElse(new Amount());
    }
}
