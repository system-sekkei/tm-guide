package guide.tm.application.service.product.bundle;

import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.product.bundle.BundleProducts;

public interface BundleProductRepository {
    BundleProducts bundleProducts();

    void register(BundleProduct bundleProduct);
}
