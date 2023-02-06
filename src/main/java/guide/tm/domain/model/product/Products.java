package guide.tm.domain.model.product;

import java.util.List;

/**
 * 商品の一覧
 */
public class Products {
    List<Product> list;

    public List<Product> list() {
        return list;
    }

    public Products(List<Product> list) {
        this.list = list;
    }
}
