package guide.tm.domain.model.customer;

/**
 * 顧客番号
 */
public class CustomerNumber {
    String value;

    public CustomerNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
