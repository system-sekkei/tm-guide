package guide.tm.domain.model.salesorder.orderitem.single;

import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.TotalAmount;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 受注明細のリスト
 */
public class SingleProductOrderItems {
    List<SingleOrderItem> list;

    public SingleProductOrderItems(List<SingleOrderItem> list) {
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
                .map(SingleOrderItem::amountExcludingTax)
                .collect(Collectors.toUnmodifiableSet()));
    }

    public List<SingleOrderItem> list() {
        return list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(SingleOrderItem singleOrderItem) {
        return list.stream()
                .anyMatch(it -> it.salesOrderItemNumber().isSame(singleOrderItem.salesOrderItemNumber()));
    }
}
