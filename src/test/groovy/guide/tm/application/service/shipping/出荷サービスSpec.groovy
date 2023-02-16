package guide.tm.application.service.shipping

import guide.tm.application.CustomerSetUp
import guide.tm.application.ShippingCompanySetUp
import guide.tm.domain.model.customer.Customer
import guide.tm.domain.model.customer.CustomerName
import guide.tm.domain.model.customer.CustomerNumber
import guide.tm.domain.model.customer.CustomerType
import guide.tm.domain.model.shipping.company.ShippingCompany
import guide.tm.domain.model.shipping.company.ShippingCompanyCode
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.transaction.annotation.Transactional
import spock.lang.Specification

@SpringBootTest
@Transactional
class 出荷サービスSpec extends Specification {

    @Autowired
    ShippingService sut

    @Autowired
    CustomerSetUp 顧客準備

    @Autowired
    ShippingCompanySetUp 運送会社準備

    def 顧客番号 = new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8")
    def 顧客 = new Customer(顧客番号, new CustomerName("梅宮 留美"), CustomerType.個人)
    def 運送会社コード = new ShippingCompanyCode("96259625")
    def 運送会社 = new ShippingCompany(運送会社コード, "ヤマト運輸")

    def setup() {
        顧客準備.顧客のテストデータの準備(顧客)
        運送会社準備.運送会社のテストデータの準備(運送会社)
    }

//    def "出荷を登録する"() {
//        given:
//        def 出荷日 = new ShippingDate(LocalDate.of(2023, Month.MARCH, 2))
//        def 出荷 = new Shipping(顧客番号, 出荷日, 運送会社コード)
//
//        when:"出荷を登録する"
//        def 出荷番号 = sut.register(出荷, salesOrderItemsToShip, bundleItemsToShip)
//
//        then: "出荷を取得できる"
//        def shipping = sut.shippingOf(出荷番号)
//        assert shipping.shippingDate.toString() == "2023-03-02"
//    }
}
