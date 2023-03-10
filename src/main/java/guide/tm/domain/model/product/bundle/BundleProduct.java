package guide.tm.domain.model.product.bundle;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;
import guide.tm.domain.model.tax.context.TaxRateType;

/**
 * セット商品
 */
public class BundleProduct {
    ProductCode code;
    ProductName name;
    BundleProductItems bundleProductItems;
    UnitPrice unitPrice;
    TaxRateType taxRateType;

    public BundleProduct() {
        this(new ProductCode(), new ProductName(), new BundleProductItems(), new UnitPrice(), TaxRateType.通常税率);
    }

    public BundleProduct(ProductCode code, ProductName name, BundleProductItems bundleProductItems, UnitPrice unitPrice, TaxRateType taxRateType) {
        this.code = code;
        this.name = name;
        this.bundleProductItems = bundleProductItems;
        this.unitPrice = unitPrice;
        this.taxRateType = taxRateType;
    }

    public boolean isReducedTaxRateProduct() {
        return taxRateType.is軽減税率();
    }

    public boolean isNormalTaxRateProduct() {
        return taxRateType.is通常税率();
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
