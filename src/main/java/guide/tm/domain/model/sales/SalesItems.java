package guide.tm.domain.model.sales;

import guide.tm.domain.model.tax.TaxContext;
import guide.tm.domain.primitive.Amount;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 受注明細のリスト
 */
public class SalesItems {
    List<SalesItem> list;

    public SalesItems(List<SalesItem> list) {
        this.list = list;
    }


    /**
     * 税抜き金額
     */
    Amount amountExcludingTax() {
        return salesAmount().total();
    }

    SalesAmount salesAmount() {
        return new SalesAmount(list.stream()
                .map(SalesItem::amountExcludingTax)
                .collect(Collectors.toUnmodifiableSet()));
    }

    /**
     * 税込金額
     */
    Amount amountIncludingTax(TaxContext taxContext) {
        return taxContext.totalOf(salesAmount());
//        return salesAmount().total(taxContext);
    }

}
