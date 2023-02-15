package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.TotalAmount;
import guide.tm.domain.model.tax.context.TaxContext;

import java.util.List;
import java.util.stream.Collectors;

/**
 * セット商品の受注明細一覧
 */
public class BundleProductOrderItems {
    List<BundleProductOrderItem> list;

    public BundleProductOrderItems(List<BundleProductOrderItem> list) {
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
                .map(BundleProductOrderItem::amountExcludingTax)
                .collect(Collectors.toUnmodifiableSet()));
    }

    public List<BundleProductOrderItem> list() {
        return list;
    }

    public boolean contains(BundleProductOrderItem bundleProductOrderItem) {
        return list.stream()
                .anyMatch(it -> it.salesOrderItemNumber().isSame(bundleProductOrderItem.salesOrderItemNumber()));
    }
}
