package guide.tm.domain.model.product.bundle;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;

/**
 * セット商品
 */
public class BundleProduct {
    ProductCode code;
    ProductName name;
    BundleProductItems bundleProductItems;
    UnitPrice unitPrice;
}
