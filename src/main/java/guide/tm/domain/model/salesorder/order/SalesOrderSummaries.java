package guide.tm.domain.model.salesorder.order;

import java.util.List;

/**
 * 受注サマリーのリスト
 */
public class SalesOrderSummaries {
    List<SalesOrderSummary> list;

    public SalesOrderSummaries(List<SalesOrderSummary> list) {
        this.list = list;
    }

    public List<SalesOrderSummary> list() {
        return list;
    }
}
