package guide.tm.application.service.salesorder

import guide.tm.application.CustomerSetUp
import guide.tm.domain.model.customer.Customer
import guide.tm.domain.model.customer.CustomerName
import guide.tm.domain.model.customer.CustomerNumber
import guide.tm.domain.model.customer.CustomerType
import guide.tm.domain.model.salesorder.order.OrderedDate
import guide.tm.domain.model.salesorder.order.SalesOrder
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

import java.time.LocalDate

@SpringBootTest
@Transactional
class 受注サービスSpec extends Specification{

    @Autowired
    SalesOrderService sut

    @Autowired
    CustomerSetUp 顧客準備
    def 顧客 = new Customer(new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"), new CustomerName("梅宮 留美"), CustomerType.個人)

    def setup() {
        顧客準備.顧客のテストデータの準備(顧客)
    }

    def 受注を登録する() {
        given:
        def 受注 = new SalesOrder(顧客, new OrderedDate("2023-01-12"))

        when: "受注を登録する"
        def 受注番号 = sut.registerSalesOrder(受注)

        then: "受注を取得する"
        def 登録された受注 = sut.salesOrderOf(受注番号)
        assert 登録された受注.customer.code.value == "39d3f994-6cd3-4a56-a2b5-d493f030cbc8"
        assert 登録された受注.customer.name.value == "梅宮 留美"
        assert 登録された受注.orderedDate.value.isEqual(LocalDate.of(2023, 1, 12))

    }
}
