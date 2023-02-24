package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.model.tax.context.TaxSumType;
import guide.tm.domain.primitive.Amount;
import guide.tm.domain.primitive.Quantity;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 受注明細Test {

    SingleProductOrderItems sut = new SingleProductOrderItems(List.of(
            new SingleOrderItem(
                    new SalesOrderItemNumber(),
                    new SingleOrderItemContent(
                            new SingleProduct(new ProductCode("821010"), new ProductName("専用ボトル"), new UnitPrice(4455), TaxRateType.通常税率),
                            new Quantity(1))
            ),
            new SingleOrderItem(
                    new SalesOrderItemNumber(),
                    new SingleOrderItemContent(
                            new SingleProduct(new ProductCode("821011"), new ProductName("専用ボトルキャップ"), new UnitPrice(1203), TaxRateType.通常税率),
                            new Quantity(2))
            )
    ));


    @Test
    void 税抜き金額の取得() {
        Amount amount = sut.amountExcludingTax();
        assertEquals("6,861", amount.toString());
    }

    @Test
    void 総額計算方式での税込金額の取得() {
        Amount amount = sut.amountIncludingTax(TaxSumType.総額計算);
        // 6861 * 1.1 = 7547.1 => 切り捨て
        assertEquals("7,547", amount.toString());
    }

    @Test
    void 総額計算方式での税額の取得() {
        Amount amount = sut.taxOf(TaxSumType.総額計算);
        // 6861 * 0.1 = 686.1 => 切り捨て
        assertEquals("686", amount.toString());
    }

    @Test
    void 積上計算方式での税込金額の取得() {
        Amount amount = sut.taxOf(TaxSumType.積上計算);
        // 4455 * 01 = 445.5
        // 2406(1203 * 2) * 0.1 = 240.6
        // 445 + 240 = 685
        assertEquals("685", amount.toString());
    }

}