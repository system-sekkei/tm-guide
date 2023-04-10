package guide.tm.domain.model.salesorder.orderitem.bundle;

import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.model.tax.context.TaxSumType;
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
    public Amount amountIncludingTax(TaxSumType taxSumType) {
        return amountIncludingReducedTax(taxSumType).add(amountIncludingNormalTax(taxSumType));
    }

    Amount amountIncludingReducedTax(TaxSumType taxSumType) {
        TaxContext taxContext = new TaxContext(TaxRateType.軽減税率, taxSumType);
        return taxContext.includingTaxOf(reducesTaxRateItems().totalAmountExcludingTax());
    }

    Amount amountIncludingNormalTax(TaxSumType taxSumType) {
        TaxContext taxContext = new TaxContext(TaxRateType.軽減税率, taxSumType);
        return taxContext.includingTaxOf(normalTaxRateItems().totalAmountExcludingTax());
    }

    /**
     * 税額
     */
    public Amount taxOf(TaxSumType taxSumType) {
        return reducedTaxOf(taxSumType).add(normalTaxOf(taxSumType));
    }

    /**
     * 税抜き総額
     */
    TotalAmount totalAmountExcludingTax() {
        return new TotalAmount(list.stream()
                .map(BundleProductOrderItem::amountExcludingTax)
                .collect(Collectors.toUnmodifiableSet()));
    }

    Amount reducedTaxOf(TaxSumType taxSumType) {
        TaxContext taxContext = new TaxContext(TaxRateType.軽減税率, taxSumType);
        return taxContext.taxOf(reducesTaxRateItems().totalAmountExcludingTax());
    }

    Amount normalTaxOf(TaxSumType taxSumType) {
        TaxContext taxContext = new TaxContext(TaxRateType.通常税率, taxSumType);
        return taxContext.taxOf(normalTaxRateItems().totalAmountExcludingTax());
    }

    BundleProductOrderItems reducesTaxRateItems() {
        return new BundleProductOrderItems(
                list.stream().filter(BundleProductOrderItem::isReducedTaxRateItem).toList());
    }

    BundleProductOrderItems normalTaxRateItems() {
        return new BundleProductOrderItems(
                list.stream().filter(BundleProductOrderItem::isNormalTaxRateItem).toList());
    }

    public List<BundleProductOrderItem> list() {
        return list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

}
