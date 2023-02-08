package guide.tm.domain.model.product.bundle;

import guide.tm.domain.model.product.individual.IndividualProduct;

import java.util.List;

/**
 * セット商品内容
 */
public class BundleProductItems {
    List<IndividualProduct> list;

    BundleProductItems() {
    }

    public BundleProductItems(List<IndividualProduct> list) {
        this.list = list;
    }

    public List<IndividualProduct> list() {
        return list;
    }
}
