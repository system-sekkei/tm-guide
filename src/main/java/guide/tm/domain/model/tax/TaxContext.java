package guide.tm.domain.model.tax;

import guide.tm.domain.model.sales.SalesAmount;
import guide.tm.domain.primitive.Amount;

/**
 * 消費税の状況
 */
public class TaxContext {
    TaxRate taxRate;
    SalesTaxType salesTaxType;

    public TaxRate taxRate() {
        return taxRate;
    }

    public SalesTaxType salesTaxType() {
        return salesTaxType;
    }

    /**
     * 消費税の適用条件に合わせて、税額を算出する
     */
    public Amount totalOf(SalesAmount salesAmount) {
        if (salesTaxType().is総額計算()) {
            return salesAmount.total().multiply(taxRate);
        }
        return salesAmount.totalOfEach(taxRate);
    }
}
