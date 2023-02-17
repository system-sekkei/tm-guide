package guide.tm.application.service.product.single;

import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.product.single.SingleProducts;

public interface ProductRepository {
    void register(SingleProduct singleProduct);

    SingleProducts products();
}
