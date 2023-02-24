package guide.tm.application.service.shipping

import guide.tm.application.CustomerSetUp
import guide.tm.application.ProductSetUp
import guide.tm.application.StockSetup
import guide.tm.application.WareHouseSetUp
import guide.tm.application.scenario.salesorder.SalesOrderScenario
import guide.tm.application.service.allocation.AllocationService
import guide.tm.application.service.salesorder.SalesOrderItemService
import guide.tm.application.service.salesorder.SalesOrderService
import guide.tm.domain.model.allocation.stock.Stock
import guide.tm.domain.model.allocation.warehouse.WareHouse
import guide.tm.domain.model.allocation.warehouse.WareHouseCode
import guide.tm.domain.model.customer.Customer
import guide.tm.domain.model.customer.CustomerName
import guide.tm.domain.model.customer.CustomerNumber
import guide.tm.domain.model.customer.CustomerType
import guide.tm.domain.model.product.detail.ProductCode
import guide.tm.domain.model.product.detail.ProductName
import guide.tm.domain.model.product.price.UnitPrice
import guide.tm.domain.model.product.single.SingleProduct
import guide.tm.domain.model.salesorder.content.OrderedDate
import guide.tm.domain.model.salesorder.content.SalesOrderContent
import guide.tm.domain.model.salesorder.order.SalesOrderNumber
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent
import guide.tm.domain.model.shipping.content.ShippingDate
import guide.tm.domain.model.shipping.content.ShippingInstructionContent
import guide.tm.domain.model.tax.context.TaxRateType
import guide.tm.domain.primitive.Quantity
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
    @Autowired
    AllocationService allocationService

    @Autowired
    SalesOrderScenario salesOrderScenario

    SalesOrderNumber 受注番号

    def 専用ボトル = new SingleProduct(
            new ProductCode("821009"),
            new ProductName("専用ボトル"),
            new UnitPrice(4400),
            TaxRateType.通常税率
    )

    def 受注明細_専用ボトル = new SingleOrderItemContent(専用ボトル, new Quantity(42))

    def 専用ボトルキャップ = new SingleProduct(
            new ProductCode("821010"),
            new ProductName("専用ボトルキャップ"),
            new UnitPrice(1200),
            TaxRateType.通常税率
    )

    def 受注明細_専用ボトルキャップ = new SingleOrderItemContent(専用ボトルキャップ, new Quantity(23))

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

    def 顧客番号 = new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8")
    def 顧客 = new Customer(顧客番号, new CustomerName("梅宮 留美"), CustomerType.個人)

    void setup() {
        顧客準備.顧客のテストデータの準備(顧客)

        def 東日本倉庫 = new WareHouse(new WareHouseCode("654321"), "東日本倉庫", "千葉県")
        def 西日本倉庫 = new WareHouse(new WareHouseCode("987655"), "西日本倉庫", "奈良県")
        def 中日本倉庫 = new WareHouse(new WareHouseCode("254i66"), "中日本倉庫", "静岡県")

        倉庫準備.倉庫のテストデータの準備(List.of(東日本倉庫, 西日本倉庫, 中日本倉庫))
        商品準備.商品のテストデータの準備(専用ボトル)
        商品準備.商品のテストデータの準備(専用ボトルキャップ)

        在庫準備.在庫のテストデータの準備(List.of(
                new Stock(専用ボトル.code(), 東日本倉庫.wareHouseCode, new Quantity(23)),
                new Stock(専用ボトル.code(), 西日本倉庫.wareHouseCode, new Quantity(8)),
                new Stock(専用ボトル.code(), 中日本倉庫.wareHouseCode, new Quantity(38)),
                new Stock(専用ボトルキャップ.code(), 東日本倉庫.wareHouseCode, new Quantity(2)),
                new Stock(専用ボトルキャップ.code(), 西日本倉庫.wareHouseCode, new Quantity(60)),
                new Stock(専用ボトルキャップ.code(), 中日本倉庫.wareHouseCode, new Quantity(18)),
            )
        )

        def 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"))
        受注番号 = 受注Service.registerSalesOrder(受注)
        受注明細Service.register(受注番号, 受注明細_専用ボトル)
        受注明細Service.register(受注番号, 受注明細_専用ボトルキャップ)
    }

    def "出荷明細を登録する"() {
        given:
        def 出荷日 = new ShippingDate(LocalDate.of(2023, Month.MARCH, 2))
        def 出荷 = new ShippingInstructionContent(受注番号, 出荷日)

        and: "引当して、結果を登録する"
        def 受注明細状況 = salesOrderScenario.status(受注番号)
        allocationService.allocateSalesOrder(受注明細状況, 受注番号)

        and: "引当を取得できる"
        def 個別商品引当結果= allocationService.singleAllocationsOf(受注番号)
        def セット商品引当結果= allocationService.bundleAllocations(受注番号)

        def 出荷番号 = 出荷サービス.register(出荷, 個別商品引当結果, セット商品引当結果)


        when: "出荷明細を取得する"
        def shippingItems = sut.shippingItems(受注番号)
        then: "出荷明細を2件取得できる"
        assert shippingItems.singleShippingItems.list.size() == 5

        and: "専用ボトルの出荷数は42"
        shippingItems.singleShippingItems.list.findAll { it.singleProduct.code.value == "821009" }.size() == 3

        and: "専用ボトルキャップの出荷数は23"
        shippingItems.singleShippingItems.list.findAll { it.singleProduct.code.value == "821010" }.size() == 2
    }
}
