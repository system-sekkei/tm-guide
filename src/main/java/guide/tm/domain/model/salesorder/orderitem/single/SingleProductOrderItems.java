package guide.tm.domain.model.salesorder.orderitem.single;

import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.model.tax.context.TaxSumType;
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
    public Amount amountIncludingTax(TaxSumType taxSumType) {
        return amountIncludingReducedTax(taxSumType).add(amountIncludingNormalTax(taxSumType));
    }

    Amount amountIncludingReducedTax(TaxSumType taxSumType) {
        TaxContext taxContext = new TaxContext(TaxRateType.軽減税率, taxSumType);
        return taxContext.includingTaxOf(reducesTaxRateItems().totalAmountExcludingTax());
    }

    Amount amountIncludingNormalTax(TaxSumType taxSumType) {
        TaxContext taxContext = new TaxContext(TaxRateType.通常税率, taxSumType);
        return taxContext.includingTaxOf(normalTaxRateItems().totalAmountExcludingTax());
    }

    /**
     * 税額
     */
    public Amount taxOf(TaxSumType taxSumType) {
        return reducedTaxOf(taxSumType).add(normalTaxOf(taxSumType));
    }


    TotalAmount totalAmountExcludingTax() {
        return new TotalAmount(list.stream()
                .map(SingleOrderItem::amountExcludingTax)
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

    SingleProductOrderItems reducesTaxRateItems() {
        return new SingleProductOrderItems(
                list.stream().filter(SingleOrderItem::isReducedTaxRateItem).toList());
    }

    SingleProductOrderItems normalTaxRateItems() {
        return new SingleProductOrderItems(
                list.stream().filter(SingleOrderItem::isNormalTaxRateItem).toList());
    }

    public List<SingleOrderItem> list() {
        return list;
    }

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public boolean contains(SalesOrderItemNumber salesOrderItemNumber) {
        return list.stream()
                .anyMatch(item -> item.salesOrderItemNumber.isSame(salesOrderItemNumber));
    }
}
