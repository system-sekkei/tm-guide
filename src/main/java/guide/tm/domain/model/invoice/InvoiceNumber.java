package guide.tm.domain.model.invoice;

/**
 * 請求番号
 */
public class InvoiceNumber {
    String value;

    @Deprecated InvoiceNumber() {
    }

    public InvoiceNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
