package guide.tm.infrastructure.datasource.product;

import guide.tm.application.service.product.individual.ProductRepository;
import guide.tm.domain.model.product.individual.IndividualProducts;
import guide.tm.domain.model.product.individual.SingleProduct;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDataSource implements ProductRepository {

    ProductMapper productMapper;

    ProductDataSource(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    @Override
    public void register(SingleProduct singleProduct) {
        productMapper.register(singleProduct);
    }

    @Override
    public IndividualProducts products() {
        return new IndividualProducts(productMapper.products());
    }
}
