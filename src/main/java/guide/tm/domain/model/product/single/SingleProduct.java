package guide.tm.domain.model.product.single;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;
import guide.tm.domain.model.tax.context.TaxRateType;

/**
 * 商品
 */
public class SingleProduct {
    ProductCode code;
    ProductName name;
    UnitPrice unitPrice;
    TaxRateType taxRateType;

    public SingleProduct() {
        this(new ProductCode(), new ProductName(), new UnitPrice(), TaxRateType.通常税率);
    }

    public SingleProduct(ProductCode code, ProductName name, UnitPrice unitPrice, TaxRateType taxRateType) {
        this.code = code;
        this.name = name;
        this.unitPrice = unitPrice;
        this.taxRateType = taxRateType;
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

    public boolean isReducedTaxRateProduct() {
        return taxRateType.is軽減税率();
    }

    public boolean isNormalTaxRateProduct() {
        return taxRateType.is通常税率();
    }
}
