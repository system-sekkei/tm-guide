package guide.tm.domain.model.salesorder.orderitem.bundle;

import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.TotalAmount;

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


    /**
     * 税抜き総額
     */
    TotalAmount totalAmountExcludingTax() {
        return new TotalAmount(list.stream()
                .map(BundleProductOrderItem::amountExcludingTax)
                .collect(Collectors.toUnmodifiableSet()));
    }

    public List<BundleProductOrderItem> list() {
        return list;
    }

}
