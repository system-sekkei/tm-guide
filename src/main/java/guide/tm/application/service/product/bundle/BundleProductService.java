package guide.tm.application.service.product.bundle;

import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.product.bundle.BundleProducts;
import org.springframework.stereotype.Service;

/**
 * セット商品サービス
 */
@Service
public class BundleProductService {
    BundleProductRepository bundleProductRepository;

    BundleProductService(BundleProductRepository bundleProductRepository) {
        this.bundleProductRepository = bundleProductRepository;
    }

    public BundleProducts bundleProducts() {
        return bundleProductRepository.bundleProducts();
    }

    /**
     * 商品を登録する
     */
    public void register(BundleProduct bundleProduct) {
        bundleProductRepository.register(bundleProduct);
    }

}
