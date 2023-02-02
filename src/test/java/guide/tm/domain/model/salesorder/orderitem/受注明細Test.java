package guide.tm.domain.model.salesorder.orderitem;

import guide.tm.domain.model.primitive.Amount;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.Product;
import guide.tm.domain.model.product.ProductCode;
import guide.tm.domain.model.product.ProductName;
import guide.tm.domain.model.product.UnitPrice;
import guide.tm.domain.model.tax.context.TaxContext;
import guide.tm.domain.model.tax.context.TaxRate;
import guide.tm.domain.model.tax.context.TaxSumType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class 受注明細Test {

    SalesOrderItems sut = new SalesOrderItems(List.of(
            new SalesOrderItem(new Product(new ProductCode("821010"), new ProductName("専用ボトル"), new UnitPrice(4455)), new Quantity(1)),
            new SalesOrderItem(new Product(new ProductCode("821011"), new ProductName("専用ボトルキャップ"), new UnitPrice(1203)), new Quantity(2))
    ));


    TaxContext 総額計算 = new TaxContext(new TaxRate(BigDecimal.valueOf(10)), TaxSumType.総額計算);
    TaxContext 積上計算 = new TaxContext(new TaxRate(BigDecimal.valueOf(10)), TaxSumType.積上計算);


    @Test
    void 税抜き金額の取得() {
        Amount amount = sut.amountExcludingTax();
        assertEquals("6861", amount.toString());
    }

    @Test
    void 総額計算方式での税込金額の取得() {
        Amount amount = sut.amountIncludingTax(総額計算);
        // 6861 * 1.1 = 7547.1 => 切り捨て
        assertEquals("7547", amount.toString());
    }

    @Test
    void 総額計算方式での税額の取得() {
        Amount amount = sut.taxOf(総額計算);
        // 6861 * 0.1 = 686.1 => 切り捨て
        assertEquals("686", amount.toString());
    }

    @Test
    void 積上計算方式での税込金額の取得() {
        Amount amount = sut.taxOf(積上計算);
        // 4455 * 01 = 445.5
        // 2406(1203 * 2) * 0.1 = 240.6
        // 445 + 240 = 685
        assertEquals("685", amount.toString());
    }

}