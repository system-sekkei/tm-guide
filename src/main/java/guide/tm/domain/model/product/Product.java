package guide.tm.domain.model.product;

/**
 * 商品
 */
public class Product {
    ProductCode code;
    ProductName name;
    UnitPrice unitPrice;

    public Product() {
        this(new ProductCode(), new ProductName(), new UnitPrice());
    }

    public Product(ProductCode code, ProductName name, UnitPrice unitPrice) {
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
