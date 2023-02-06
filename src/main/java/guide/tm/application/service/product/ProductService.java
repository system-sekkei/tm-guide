package guide.tm.application.service.product;

import guide.tm.domain.model.product.Product;
import guide.tm.domain.model.product.Products;
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
    public void register(Product product) {
        productRepository.register(product);
    }

    public Products products() {
        return productRepository.products();
    }
}
