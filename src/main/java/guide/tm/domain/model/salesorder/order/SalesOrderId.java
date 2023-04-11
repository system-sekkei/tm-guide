package guide.tm.domain.model.salesorder.order;

/**
 * 受注ID
 */
public class SalesOrderId {
    String value;

    public SalesOrderId() {
        this("");
    }

    public SalesOrderId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

}
