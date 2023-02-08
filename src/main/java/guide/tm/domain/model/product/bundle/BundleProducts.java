package guide.tm.domain.model.product.bundle;

import java.util.List;

/**
 * セット商品のリスト
 */
public class BundleProducts {
    List<BundleProduct> list;

    public BundleProducts(List<BundleProduct> list) {
        this.list = list;
    }

    public List<BundleProduct> list() {
        return list;
    }
}
