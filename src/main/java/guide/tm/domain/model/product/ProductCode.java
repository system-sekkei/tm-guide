package guide.tm.domain.model.product;

/**
 * 商品コード
 */
public class ProductCode {
    String value;

    ProductCode() {
        this("");
    }

    public ProductCode(String value) {
        this.value = value;
    }
}
