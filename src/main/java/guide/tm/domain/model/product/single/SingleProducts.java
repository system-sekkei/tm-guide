package guide.tm.domain.model.product.single;

import java.util.List;

/**
 * 商品の一覧
 */
public class SingleProducts {
    List<SingleProduct> list;

    public List<SingleProduct> list() {
        return list;
    }

    public SingleProducts(List<SingleProduct> list) {
        this.list = list;
    }
}
