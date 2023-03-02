package guide.tm.application.service.stock;

import guide.tm.application.fixture.倉庫Fixture;
import guide.tm.application.fixture.商品Fixture;
import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.stock.Stocks;
import guide.tm.domain.model.allocation.warehouse.WareHouse;
import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.content.Prefecture;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.primitive.Quantity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
@SpringBootTest
@Transactional
class 在庫サービスTest {

    @Autowired
    StockService sut;

    @Autowired
    倉庫Fixture 倉庫準備;

    @Autowired
    商品Fixture 商品準備;

    WareHouse 東日本倉庫 = new WareHouse(new WareHouseCode("654321"), "東日本倉庫", "千葉県");
    WareHouse 西日本倉庫 = new WareHouse(new WareHouseCode("098765"), "西日本倉庫", "奈良県");

    SingleProduct 専用ボトル = new SingleProduct(
            new ProductCode("821009"),
            new ProductName("専用ボトル"),
            new UnitPrice(4400),
            TaxRateType.通常税率
    );

    SingleProduct 専用ボトルキャップ = new SingleProduct(
            new ProductCode("821010"),
            new ProductName("専用ボトルキャップ"),
            new UnitPrice(1200),
            TaxRateType.通常税率
    );

    @BeforeEach
    void setup() {
        倉庫準備.倉庫のテストデータの準備(List.of(東日本倉庫, 西日本倉庫));
        商品準備.商品のテストデータの準備(List.of(専用ボトル, 専用ボトルキャップ));
    }

    @Test
    void 在庫を取得する() {
        // given: "在庫を設定する"

        // and: "東日本倉庫の専用ボトル在庫を設定する"
        Stock 東日本倉庫の専用ボトル在庫 = new Stock(専用ボトル.code(), 東日本倉庫.wareHouseCode(), Prefecture.千葉県, new Quantity(15));
        sut.register(東日本倉庫の専用ボトル在庫);

        // and: "西日本倉庫の専用ボトル在庫を設定する"
        Stock 西日本倉庫の専用ボトル在庫 = new Stock(専用ボトル.code(), 西日本倉庫.wareHouseCode(), Prefecture.奈良県, new Quantity(21));
        sut.register(西日本倉庫の専用ボトル在庫);

        // when: "専用ボトルの在庫を取得する"
        Stocks 専用ボトルの在庫 = sut.stocksOf(専用ボトル);

        // then: "東日本倉庫と西日本倉庫の専用ボトル在庫を取得できる"
        assertEquals(2, 専用ボトルの在庫.list().size());

        // and: "東日本倉庫と在庫数は15"
        assertTrue(専用ボトルの在庫.list().stream()
                .filter(it -> it.wareHouseCode().isSame(new WareHouseCode("654321")))
                .findFirst()
                .orElseThrow()
                .quantity().isEqual(new Quantity(15)));


    }
}