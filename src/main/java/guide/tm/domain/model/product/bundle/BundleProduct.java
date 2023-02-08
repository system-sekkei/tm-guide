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

    public BundleProduct() {
        this(new ProductCode(), new ProductName(), new BundleProductItems(), new UnitPrice());
    }

    public BundleProduct(ProductCode code, ProductName name, BundleProductItems bundleProductItems, UnitPrice unitPrice) {
        this.code = code;
        this.name = name;
        this.bundleProductItems = bundleProductItems;
        this.unitPrice = unitPrice;
    }

    public ProductCode code() {
        return code;
    }

    public ProductName name() {
        return name;
    }

    public UnitPrice unitPrice() {
        return unitPrice;
    }

    public BundleProductItems bundleProductItems() {
        return bundleProductItems;
    }
}
