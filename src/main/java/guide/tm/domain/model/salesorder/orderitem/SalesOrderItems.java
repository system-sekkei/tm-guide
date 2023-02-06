package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.TotalAmount;
import guide.tm.domain.model.tax.context.TaxContext;

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
    public Amount amountExcludingTax() {
        return totalAmountExcludingTax().total();
    }

    /**
     * 税込金額
     */
    public Amount amountIncludingTax(TaxContext taxContext) {
        return taxContext.includingTaxOf(totalAmountExcludingTax());
    }

    /**
     * 税額
     */
    public Amount taxOf(TaxContext taxContext) {
        return taxContext.taxOf(totalAmountExcludingTax());
    }


    TotalAmount totalAmountExcludingTax() {
        return new TotalAmount(list.stream()
                .map(SalesOrderItem::amountExcludingTax)
                .collect(Collectors.toUnmodifiableSet()));
    }

    public List<SalesOrderItem> list() {
        return list;
    }
}
