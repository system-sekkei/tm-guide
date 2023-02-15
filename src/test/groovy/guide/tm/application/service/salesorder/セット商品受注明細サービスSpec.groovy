package guide.tm.application.service.salesorder

import guide.tm.application.CustomerSetUp
import guide.tm.application.ProductSetUp
import guide.tm.domain.model.customer.Customer
import guide.tm.domain.model.customer.CustomerName
import guide.tm.domain.model.customer.CustomerNumber
import guide.tm.domain.model.customer.CustomerType
import guide.tm.domain.model.primitive.Quantity
import guide.tm.domain.model.product.bundle.BundleProduct
import guide.tm.domain.model.product.bundle.BundleProductItems
import guide.tm.domain.model.product.detail.ProductCode
import guide.tm.domain.model.product.detail.ProductName
import guide.tm.domain.model.product.individual.SingleProduct
import guide.tm.domain.model.product.price.UnitPrice
import guide.tm.domain.model.salesorder.content.OrderedDate
import guide.tm.domain.model.salesorder.content.SalesOrderContent
import guide.tm.domain.model.salesorder.orderitem.BundleProductOrderItemContent
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@Transactional
class セット商品受注明細サービスSpec extends Specification {

    @Autowired
    SalesOrderItemService sut

    @Autowired
    SalesOrderService salesOrderService

    @Autowired
    ProductSetUp 商品準備

    @Autowired
    CustomerSetUp 顧客準備

    def 尾西のご飯 = new SingleProduct(
            new ProductCode("821009"),
            new ProductName("尾西のご飯"),
            new UnitPrice(4400))

    def サタケのマジックパスタ = new SingleProduct(
            new ProductCode("821010"),
            new ProductName("サタケのマジックパスタ"),
            new UnitPrice(1200))

    def 非常食セット = new BundleProduct(
            new ProductCode("9807987"),
            new ProductName("非常食セット_受注明細"),
            new BundleProductItems(List.of(尾西のご飯, サタケのマジックパスタ)),
            new UnitPrice(5200)
    )

    def 顧客 = new Customer(
            new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"),
            new CustomerName("梅宮 留美"),
            CustomerType.個人)


    def setup() {
        顧客準備.顧客のテストデータの準備(顧客)
        商品準備.商品のテストデータの準備(List.of(尾西のご飯, サタケのマジックパスタ))
        商品準備.セット商品のテストデータ準備(List.of(非常食セット))

    }

    def セット品受注明細を登録する() {
        given:
        def 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"))
        def 非常食セット_受注明細 = new BundleProductOrderItemContent(非常食セット, new Quantity(1))

        when: "セット品受注明細を登録する"
        def 受注番号 = salesOrderService.registerSalesOrder(受注)
        sut.registerBundleProductOrderItem(受注番号, 非常食セット_受注明細)

        then: "セット品受注明細を取得する"
        def 登録された受注明細 = sut.bundleProductOrderItemsOf(受注番号)

        assert 登録された受注明細.list.size() == 1

        and: "非常食セット_受注明細の受注明細の受注数は1"
        def 非常食セット受注明細 = 登録された受注明細.list.find { it -> it.bundleProduct().code.value == "9807987"}
        assert 非常食セット受注明細.quantity().value == 1

    }
}
