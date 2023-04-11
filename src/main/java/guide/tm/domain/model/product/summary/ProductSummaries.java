package guide.tm.domain.model.product.summary;

import java.util.ArrayList;
import java.util.List;

/**
 * 商品サマリー一覧
 */
public class ProductSummaries {
    List<ProductSummary> list;

    public ProductSummaries(List<ProductSummary> list) {
        this.list = list;
    }

    public ProductSummaries merge(ProductSummaries other) {
        List<ProductSummary> result = new ArrayList<>();
        result.addAll(list);
        result.addAll(other.list);
        return new ProductSummaries(result);
    }
}
