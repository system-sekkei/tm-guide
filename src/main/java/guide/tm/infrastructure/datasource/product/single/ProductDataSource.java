package guide.tm.infrastructure.datasource.product.single;

import guide.tm.application.service.product.single.ProductRepository;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.product.single.SingleProducts;
import guide.tm.domain.model.product.summary.ProductSearchCriteria;
import guide.tm.domain.model.product.summary.ProductSummaries;
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
    public SingleProducts products() {
        return new SingleProducts(productMapper.products());
    }

    @Override
    public ProductSummaries searchBy(ProductSearchCriteria productSearchCriteria) {
        ProductSummaries singles = new ProductSummaries(productMapper.searchSingleProducts(productSearchCriteria));
        ProductSummaries bundles = new ProductSummaries(productMapper.searchBundleProducts(productSearchCriteria));

        return singles.merge(bundles);
    }
}
