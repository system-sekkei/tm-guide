package guide.tm.application.fixture;

import guide.tm.application.service.product.bundle.BundleProductService;
import guide.tm.application.service.product.single.ProductService;
import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.product.single.SingleProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class 商品Fixture {

    @Autowired
    ProductService productService;

    @Autowired
    BundleProductService bundleProductService;

    public void 商品のテストデータの準備(SingleProduct 商品) {
        productService.register(商品);
    }

    public void 商品のテストデータの準備(List<SingleProduct> 商品リスト) {
        商品リスト.forEach(商品 -> productService.register(商品));
    }

    public void セット商品のテストデータ準備(BundleProduct bundleProduct) {
        bundleProductService.register(bundleProduct);
    }

    public void セット商品のテストデータ準備(List<BundleProduct> セット商品のリスト) {
        セット商品のリスト.forEach(this::セット商品のテストデータ準備);
    }
}
