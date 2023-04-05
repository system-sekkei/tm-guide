package guide.tm.domain.model.invoice;

/**
 * 請求ステータス
 */
public enum InvoiceStatus {
    請求済,
    未請求,
    ;

    public boolean isInvoiced() {
       return this == 請求済;
    }
}
