package guide.tm.application.service.product;

import guide.tm.domain.model.product.individual.IndividualProduct;
import guide.tm.domain.model.product.individual.IndividualProducts;

public interface ProductRepository {
    void register(IndividualProduct individualProduct);

    IndividualProducts products();
}
