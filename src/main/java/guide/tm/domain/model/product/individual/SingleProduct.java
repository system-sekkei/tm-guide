package guide.tm.domain.model.product.individual;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;

/**
 * 商品
 */
public class SingleProduct {
    ProductCode code;
    ProductName name;
    UnitPrice unitPrice;

    public SingleProduct() {
        this(new ProductCode(), new ProductName(), new UnitPrice());
    }

    public SingleProduct(ProductCode code, ProductName name, UnitPrice unitPrice) {
        this.code = code;
        this.name = name;
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
}
