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

    /**
     * セット商品を取得する
     */
    public BundleProducts bundleProducts() {
        return bundleProductRepository.bundleProducts();
    }

    /**
     * セット商品を登録する
     */
    public void register(BundleProduct bundleProduct) {
        bundleProductRepository.register(bundleProduct);
    }

}
