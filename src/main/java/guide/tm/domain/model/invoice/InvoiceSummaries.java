package guide.tm.domain.model.invoice;

import java.util.List;

/**
 * 請求サマリーの一覧
 */
public class InvoiceSummaries {
    List<InvoiceSummary> list;

    public InvoiceSummaries(List<InvoiceSummary> list) {
        this.list = list;
    }

    public List<InvoiceSummary> list() {
        return list;
    }
}
