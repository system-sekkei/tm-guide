package guide.tm.domain.model.sales;

import java.util.List;

/**
 * 受注明細のリスト
 */
public class SalesItems {
    List<SalesItem> list;

    public SalesItems(List<SalesItem> list) {
        this.list = list;
    }
}
