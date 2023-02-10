package guide.tm.domain.model.product.detail;

/**
 * 商品コード
 */
public class ProductCode {
    String value;

    public ProductCode() {
        this("");
    }

    public ProductCode(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isSame(ProductCode other) {
        return value.equals(other.value);
    }
}
