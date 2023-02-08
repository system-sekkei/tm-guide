package guide.tm.infrastructure.datasource.product.bundle;

import guide.tm.application.service.product.bundle.BundleProductRepository;
import guide.tm.domain.model.product.bundle.BundleProducts;
import org.springframework.stereotype.Repository;

@Repository
public class BundleProductDataSource implements BundleProductRepository {

    BundleProductMapper bundleProductMapper;

    BundleProductDataSource(BundleProductMapper bundleProductMapper) {
        this.bundleProductMapper = bundleProductMapper;
    }

    @Override
    public BundleProducts bundleProducts() {
        return new BundleProducts(bundleProductMapper.bundleProducts());
    }
}
