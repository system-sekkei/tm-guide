package guide.tm.application.service.product.single;

import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.product.single.SingleProducts;
import guide.tm.domain.model.product.summary.ProductSearchCriteria;
import guide.tm.domain.model.product.summary.ProductSummaries;

public interface ProductRepository {
    void register(SingleProduct singleProduct);

    SingleProducts products();

    ProductSummaries searchBy(ProductSearchCriteria productSearchCriteria);
}
