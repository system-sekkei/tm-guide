package guide.tm.domain.model.sales;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.TotalAmount;
import guide.tm.domain.model.tax.TaxContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 受注明細のリスト
 */
public class SalesOrderItems {
    List<SalesOrderItem> list;

    public SalesOrderItems(List<SalesOrderItem> list) {
        this.list = list;
    }

    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return totalAmountExcludingTax().total();
    }

    /**
     * 税込金額
     */
    Amount amountIncludingTax(TaxContext taxContext) {
        return taxContext.includingTaxOf(totalAmountExcludingTax());
    }

    TotalAmount totalAmountExcludingTax() {
        return new TotalAmount(list.stream()
                .map(SalesOrderItem::amountExcludingTax)
                .collect(Collectors.toUnmodifiableSet()));
    }

}
