package guide.tm.application.service.product.individual;

import guide.tm.domain.model.product.individual.IndividualProducts;
import guide.tm.domain.model.product.individual.SingleProduct;

public interface ProductRepository {
    void register(SingleProduct singleProduct);

    IndividualProducts products();
}
