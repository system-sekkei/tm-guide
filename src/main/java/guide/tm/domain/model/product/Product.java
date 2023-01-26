package guide.tm.domain.model.product;

/**
 * 商品
 */
public class Product {
    ProductCode productCode;
    UnitPrice unitPrice;

    public UnitPrice unitPrice() {
        return unitPrice;
    }
}
