package guide.tm.domain.model.product.bundle;

import guide.tm.domain.model.product.individual.SingleProduct;

import java.util.List;

/**
 * セット商品内容
 */
public class BundleProductItems {
    List<SingleProduct> list;

    BundleProductItems() {
    }

    public BundleProductItems(List<SingleProduct> list) {
        this.list = list;
    }

    public List<SingleProduct> list() {
        return list;
    }
}
