package guide.tm.domain.model.invoice;

/**
 * 請求ID
 */
public class InvoiceId {

    String value;

    @Deprecated InvoiceId() {
    }

    public InvoiceId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
