package guide.tm.infrastructure.datasource.product;

import guide.tm.application.service.product.ProductRepository;
import guide.tm.domain.model.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDataSource implements ProductRepository {

    ProductMapper productMapper;

    ProductDataSource(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public void register(Product product) {
        productMapper.register(product);
    }
}
