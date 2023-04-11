package guide.tm.domain.model.product.summary;

/**
 * 商品検索条件
 */
public class ProductSearchCriteria {
    String productName;

    public ProductSearchCriteria(String productName) {
        this.productName = productName;
    }
}
