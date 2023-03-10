package guide.tm.domain.model.customer;

/**
 * 顧客番号
 */
public class CustomerNumber {
    String value;

    public CustomerNumber() {
        this("");
    }

    public CustomerNumber(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public boolean isSame(CustomerNumber other) {
        return value.equals(other.value);
    }
}

