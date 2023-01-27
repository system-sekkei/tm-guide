package guide.tm.application


import guide.tm.application.service.product.ProductService
import guide.tm.domain.model.product.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductSetUp {

    @Autowired
    ProductService productService

    def "商品のテストデータの準備"(Product 商品) {
        productService.register(商品)
    }

    def "商品のテストデータの準備"(List<Product> 商品リスト) {
        商品リスト.forEach(商品 -> productService.register(商品))
    }
}
