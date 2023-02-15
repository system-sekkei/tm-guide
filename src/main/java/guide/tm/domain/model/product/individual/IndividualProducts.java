package guide.tm.domain.model.product.individual;

import java.util.List;

/**
 * 商品の一覧
 */
public class IndividualProducts {
    List<SingleProduct> list;

    public List<SingleProduct> list() {
        return list;
    }

    public IndividualProducts(List<SingleProduct> list) {
        this.list = list;
    }
}
