package guide.tm.application

import guide.tm.application.service.product.bundle.BundleProductService
import guide.tm.application.service.product.single.ProductService
import guide.tm.domain.model.product.bundle.BundleProduct
import guide.tm.domain.model.product.single.SingleProduct
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class ProductSetUp {

    @Autowired
    ProductService productService

    @Autowired
    BundleProductService bundleProductService

    def "商品のテストデータの準備"(SingleProduct 商品) {
        productService.register(商品)
    }

    def "商品のテストデータの準備"(List<SingleProduct> 商品リスト) {
        商品リスト.forEach {商品 -> productService.register(商品) }
    }

    def "セット商品のテストデータ準備"(BundleProduct bundleProduct) {
        bundleProductService.register(bundleProduct)
    }

    def "セット商品のテストデータ準備"(List<BundleProduct> セット商品のリスト) {
        セット商品のリスト.forEach {セット商品のテストデータ準備(it)}
    }
}
