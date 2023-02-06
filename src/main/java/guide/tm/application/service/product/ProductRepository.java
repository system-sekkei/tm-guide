package guide.tm.application.service.product;

import guide.tm.domain.model.product.Product;
import guide.tm.domain.model.product.Products;

public interface ProductRepository {
    void register(Product product);

    Products products();
}
