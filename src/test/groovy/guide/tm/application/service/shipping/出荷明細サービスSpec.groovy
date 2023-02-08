package guide.tm.application.service.shipping

import guide.tm.application.*
import guide.tm.application.service.salesorder.SalesOrderItemService
import guide.tm.application.service.salesorder.SalesOrderService
import guide.tm.domain.model.allocation.warehouse.WareHouse
import guide.tm.domain.model.allocation.warehouse.WareHouseCode
import guide.tm.domain.model.customer.Customer
import guide.tm.domain.model.customer.CustomerName
import guide.tm.domain.model.customer.CustomerNumber
import guide.tm.domain.model.customer.CustomerType
import guide.tm.domain.model.primitive.Quantity
import guide.tm.domain.model.product.detail.ProductCode
import guide.tm.domain.model.product.detail.ProductName
import guide.tm.domain.model.product.individual.IndividualProduct
import guide.tm.domain.model.product.price.UnitPrice
import guide.tm.domain.model.salesorder.content.OrderedDate
import guide.tm.domain.model.salesorder.content.SalesOrderContent
import guide.tm.domain.model.salesorder.order.SalesOrderNumber
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem
import guide.tm.domain.model.shipping.company.ShippingCompany
import guide.tm.domain.model.shipping.company.ShippingCompanyCode
import guide.tm.domain.model.shipping.content.Shipping
import guide.tm.domain.model.shipping.content.ShippingDate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

@SpringBootTest
@Transactional
class 出荷明細サービスSpec extends Specification {

    @Autowired
    ShippingItemService sut

    SalesOrderNumber 受注番号

    def 専用ボトル = new IndividualProduct(
            new ProductCode("821009"),
            new ProductName("専用ボトル"),
            new UnitPrice(4400))

    def 受注明細_専用ボトル = new SalesOrderItem(専用ボトル, new Quantity(42))

    def 専用ボトルキャップ = new IndividualProduct(
            new ProductCode("821010"),
            new ProductName("専用ボトルキャップ"),
            new UnitPrice(1200))

    def 受注明細_専用ボトルキャップ = new SalesOrderItem(専用ボトルキャップ, new Quantity(23))

    @Autowired
    StockSetup 在庫準備

    @Autowired
    ProductSetUp 商品準備

    @Autowired
    WareHouseSetUp 倉庫準備
    @Autowired
    CustomerSetUp 顧客準備

    @Autowired
    SalesOrderService 受注Service
    @Autowired
    SalesOrderItemService 受注明細Service

    @Autowired
    ShippingService 出荷サービス
    @Autowired
    ShippingCompanySetUp 運送会社準備

    def 顧客番号 = new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8")
    def 顧客 = new Customer(顧客番号, new CustomerName("梅宮 留美"), CustomerType.個人)
    def 運送会社コード = new ShippingCompanyCode("96259625")
    def 運送会社 = new ShippingCompany(運送会社コード, "ヤマト運輸")

    void setup() {
        顧客準備.顧客のテストデータの準備(顧客)

        def 東日本倉庫 = new WareHouse(new WareHouseCode("654321"), "東日本倉庫", "千葉県")
        def 西日本倉庫 = new WareHouse(new WareHouseCode("987655"), "西日本倉庫", "奈良県")
        def 中日本倉庫 = new WareHouse(new WareHouseCode("254i66"), "中日本倉庫", "静岡県")

        倉庫準備.倉庫のテストデータの準備(List.of(東日本倉庫, 西日本倉庫, 中日本倉庫))
        商品準備.商品のテストデータの準備(専用ボトル)
        商品準備.商品のテストデータの準備(専用ボトルキャップ)

        運送会社準備.運送会社のテストデータの準備(運送会社)
        def 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"))
        受注番号 = 受注Service.registerSalesOrder(受注)
        受注明細Service.register(受注番号, 受注明細_専用ボトル)
        受注明細Service.register(受注番号, 受注明細_専用ボトルキャップ)
    }

    def "出荷明細を登録する"() {
        given:
        def 出荷日 = new ShippingDate(LocalDate.of(2023, Month.MARCH, 2))
        def 出荷 = new Shipping(顧客番号, 出荷日, 運送会社コード)

        def 出荷番号 = 出荷サービス.register(出荷)

        def 受注明細リスト = 受注明細Service.salesOrderItemsOf(受注番号)


        when:"出荷明細を登録する"
        sut.register(出荷番号, 受注番号, 受注明細リスト.list.get(0))
        sut.register(出荷番号, 受注番号, 受注明細リスト.list.get(1))

        then: "出荷明細を2件取得できる"
        def shippingItems = sut.shippingItemsOf(出荷番号)
        assert shippingItems.list.size() == 2

        and: "専用ボトルの出荷数は42"
        shippingItems.list.find { it.individualProduct.code.value == "821009" }.shippingQuantity.value == 42

        and: "専用ボトルキャップの出荷数は23"
        shippingItems.list.find { it.individualProduct.code.value == "821010" }.shippingQuantity.value == 23
    }
}
