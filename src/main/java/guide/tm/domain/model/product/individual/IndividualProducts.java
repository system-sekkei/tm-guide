package guide.tm.domain.model.product.individual;

import java.util.List;

/**
 * 商品の一覧
 */
public class IndividualProducts {
    List<IndividualProduct> list;

    public List<IndividualProduct> list() {
        return list;
    }

    public IndividualProducts(List<IndividualProduct> list) {
        this.list = list;
    }
}
