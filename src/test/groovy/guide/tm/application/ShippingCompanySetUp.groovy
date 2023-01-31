package guide.tm.application


import guide.tm.application.service.shipping.company.ShippingCompanyService
import guide.tm.domain.model.shipping.company.ShippingCompany
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ShippingCompanySetUp {

    @Autowired
    ShippingCompanyService shippingCompanyService

    def "運送会社のテストデータの準備"(ShippingCompany 運送会社) {
        shippingCompanyService.register(運送会社)
    }
}
