package guide.tm.domain.model.customer;

/**
 * 顧客番号
 */
public class CustomerId {
    String value;

    public CustomerId() {
        this("");
    }

    public CustomerId(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public boolean isEmpty() {
        return value.isEmpty();
    }

    public boolean isSame(CustomerId other) {
        return value.equals(other.value);
    }
}

