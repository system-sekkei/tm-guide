package guide.tm.application

import guide.tm.application.service.customer.CustomerService
import guide.tm.domain.model.customer.Customer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CustomerSetUp {

    @Autowired
    CustomerService customerService

    def "顧客のテストデータの準備"(Customer 顧客) {
        customerService.register(顧客)
    }
}
