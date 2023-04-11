package guide.tm.application.service.product.single;

import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.product.summary.ProductSearchCriteria;
import guide.tm.domain.model.product.summary.ProductSummaries;
import org.springframework.stereotype.Service;

/**
 * 商品サービス
 */
@Service
public class ProductService {
    ProductRepository productRepository;

    ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    /**
     * 商品を登録する
     */
    public void register(SingleProduct singleProduct) {
        productRepository.register(singleProduct);
    }

    /**
     * 商品を検索する
     */
    public ProductSummaries searchBy(ProductSearchCriteria productSearchCriteria) {
        return productRepository.searchBy(productSearchCriteria);
    }
}
