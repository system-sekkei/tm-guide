package guide.tm.application.service.stock

import guide.tm.application.ProductSetUp
import guide.tm.application.WareHouseSetUp
import guide.tm.domain.model.allocation.stock.Stock
import guide.tm.domain.model.allocation.warehouse.WareHouse
import guide.tm.domain.model.allocation.warehouse.WareHouseCode
import guide.tm.domain.model.primitive.Quantity
import guide.tm.domain.model.product.detail.ProductCode
import guide.tm.domain.model.product.detail.ProductName
import guide.tm.domain.model.product.individual.SingleProduct
import guide.tm.domain.model.product.price.UnitPrice
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@Transactional
class 在庫サービスSpec extends Specification {

    @Autowired
    StockService sut

    @Autowired
    WareHouseSetUp wareHouseSetUp

    @Autowired
    ProductSetUp 商品準備

    def 東日本倉庫 = new WareHouse(new WareHouseCode("654321"), "東日本倉庫", "千葉県")
    def 西日本倉庫 = new WareHouse(new WareHouseCode("098765"), "西日本倉庫", "奈良県")

    def 専用ボトル = new SingleProduct(
            new ProductCode("821009"),
            new ProductName("専用ボトル"),
            new UnitPrice(4400))

    def 専用ボトルキャップ = new SingleProduct(
            new ProductCode("821010"),
            new ProductName("専用ボトルキャップ"),
            new UnitPrice(1200))

    def setup() {
        wareHouseSetUp.倉庫のテストデータの準備(List.of(東日本倉庫, 西日本倉庫))
        商品準備.商品のテストデータの準備(List.of(専用ボトル, 専用ボトルキャップ))
    }

    def "在庫を取得する"() {
        given: "在庫を設定する"

        and: "東日本倉庫の専用ボトル在庫を設定する"
        def 東日本倉庫の専用ボトル在庫 = new Stock(専用ボトル.code, 東日本倉庫.wareHouseCode, new Quantity(15))
        sut.register(東日本倉庫の専用ボトル在庫)

        and: "西日本倉庫の専用ボトル在庫を設定する"
        def 西日本倉庫の専用ボトル在庫 = new Stock(専用ボトル.code, 西日本倉庫.wareHouseCode, new Quantity(21))
        sut.register(西日本倉庫の専用ボトル在庫)

        when: "専用ボトルの在庫を取得する"
        def 専用ボトルの在庫 = sut.stocksOf(専用ボトル)

        then: "東日本倉庫と西日本倉庫の専用ボトル在庫を取得できる"
        assert 専用ボトルの在庫.list.size() == 2

        and: "東日本倉庫と在庫数は15"
        assert 専用ボトルの在庫.list.find {it.wareHouseCode.value == "654321"}.quantity.value == 15


    }
}
