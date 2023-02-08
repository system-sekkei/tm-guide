package guide.tm.application


import guide.tm.application.service.product.individual.ProductService
import guide.tm.domain.model.product.individual.IndividualProduct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductSetUp {

    @Autowired
    ProductService productService

    def "商品のテストデータの準備"(IndividualProduct 商品) {
        productService.register(商品)
    }

    def "商品のテストデータの準備"(List<IndividualProduct> 商品リスト) {
        商品リスト.forEach(商品 -> productService.register(商品))
    }
}
