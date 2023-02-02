package guide.tm.application.service.salesorder

import guide.tm.application.CustomerSetUp
import guide.tm.application.ProductSetUp
import guide.tm.domain.model.customer.Customer
import guide.tm.domain.model.customer.CustomerName
import guide.tm.domain.model.customer.CustomerNumber
import guide.tm.domain.model.customer.CustomerType
import guide.tm.domain.model.primitive.Quantity
import guide.tm.domain.model.product.Product
import guide.tm.domain.model.product.ProductCode
import guide.tm.domain.model.product.ProductName
import guide.tm.domain.model.product.UnitPrice
import guide.tm.domain.model.salesorder.content.OrderedDate
import guide.tm.domain.model.salesorder.content.SalesOrderContent
import guide.tm.domain.model.salesorder.orderitem.SalesOrderItem
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@Transactional
class 受注明細サービスSpec extends Specification {

    @Autowired
    SalesOrderItemService sut

    @Autowired
    SalesOrderService salesOrderService

    @Autowired
    ProductSetUp 商品準備

    @Autowired
    CustomerSetUp 顧客準備

    def 専用ボトル = new Product(
            new ProductCode("821009"),
            new ProductName("専用ボトル"),
            new UnitPrice(4400))

    def 専用ボトルキャップ = new Product(
            new ProductCode("821010"),
            new ProductName("専用ボトルキャップ"),
            new UnitPrice(1200))

    def 顧客 = new Customer(
            new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"),
            new CustomerName("梅宮 留美"),
            CustomerType.個人)


    def setup() {
        顧客準備.顧客のテストデータの準備(顧客)
        商品準備.商品のテストデータの準備(List.of(専用ボトル, 専用ボトルキャップ))
    }

    def 受注明細を登録する() {
        given:
        def 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"))
        def 受注明細_専用ボトル = new SalesOrderItem(専用ボトル, new Quantity(1))
        def 受注明細_専用ボトルキャップ = new SalesOrderItem(専用ボトルキャップ, new Quantity(2))

        when: "受注明細を登録する"
        def 受注番号 = salesOrderService.registerSalesOrder(受注)
        sut.register(受注番号, 受注明細_専用ボトル)
        sut.register(受注番号, 受注明細_専用ボトルキャップ)

        then: "受注明細を取得する"
        def 登録された受注明細 = sut.salesOrderItemsOf(受注番号)

        assert 登録された受注明細.list.size() == 2

        and: "専用ボトルの受注明細の受注数は1"
        def 専用ボトルの受注明細 = 登録された受注明細.list.find { it -> it.product.code.value == "821009"}
        assert 専用ボトルの受注明細.quantity.value == 1

        and: "専用ボトルキャップの受注明細の受注数は2"
        def 専用ボトルキャップの受注明細 = 登録された受注明細.list.find { it -> it.product.code.value == "821010"}
        assert 専用ボトルキャップの受注明細.quantity.value == 2

    }
}
