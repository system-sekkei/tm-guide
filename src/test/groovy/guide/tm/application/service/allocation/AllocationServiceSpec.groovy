package guide.tm.application.service.allocation

import guide.tm.application.CustomerSetUp
import guide.tm.application.ProductSetUp
import guide.tm.application.StockSetup
import guide.tm.application.WareHouseSetUp
import guide.tm.application.service.salesorder.SalesOrderItemService
import guide.tm.application.service.salesorder.SalesOrderService
import guide.tm.domain.model.allocation.stock.Stock
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
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItemContent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@Transactional
class AllocationServiceSpec extends Specification {

    @Autowired
    AllocationService sut

    SalesOrderNumber 受注番号

    def 専用ボトル = new IndividualProduct(
            new ProductCode("821009"),
            new ProductName("専用ボトル"),
            new UnitPrice(4400))

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

    def 受注明細_専用ボトル = new SalesOrderItemContent(専用ボトル, new Quantity(42))

    void setup() {
        def 顧客 = new Customer(new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"), new CustomerName("梅宮 留美"), CustomerType.個人)
        顧客準備.顧客のテストデータの準備(顧客)

        def 東日本倉庫 = new WareHouse(new WareHouseCode("654321"), "東日本倉庫", "千葉県")
        def 西日本倉庫 = new WareHouse(new WareHouseCode("987655"), "西日本倉庫", "奈良県")
        def 中日本倉庫 = new WareHouse(new WareHouseCode("254i66"), "中日本倉庫", "静岡県")

        倉庫準備.倉庫のテストデータの準備(List.of(東日本倉庫, 西日本倉庫, 中日本倉庫))
        商品準備.商品のテストデータの準備(専用ボトル)
        在庫準備.在庫のテストデータの準備(
                List.of(
                        new Stock(new ProductCode("821009"), new WareHouseCode("654321"), new Quantity(10)),
                        new Stock(new ProductCode("821009"), new WareHouseCode("987655"), new Quantity(8)),
                        new Stock(new ProductCode("821009"), new WareHouseCode("254i66"), new Quantity(13))
                )
        )
        def 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"))
        受注番号 = 受注Service.registerSalesOrder(受注)
        受注明細Service.register(受注番号, 受注明細_専用ボトル)
    }

    def "引当を登録する"() {
        given:
        def 受注明細 = 受注明細Service.salesOrderItemsOf(受注番号).list.get(0)

        when: "引当して、結果を登録する"
        sut.allocate(受注明細, 受注番号)

        then: "引当を取得できる"
        def 引当結果= sut.allocationsOf(受注番号)
        and: "引当が3件"
        assert 引当結果.list().size() == 3

    }
}
