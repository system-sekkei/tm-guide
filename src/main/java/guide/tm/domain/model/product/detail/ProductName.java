package guide.tm.domain.model.product.detail;

/**
 * 商品名称
 */
public class ProductName {
    String value;

    public ProductName() {
        this("");
    }

    public ProductName(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
