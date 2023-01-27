package guide.tm.domain.model.product;

/**
 * 商品
 */
public class Product {
    ProductCode code;
    ProductName name;
    UnitPrice unitPrice;

    public UnitPrice unitPrice() {
        return unitPrice;
    }
}
