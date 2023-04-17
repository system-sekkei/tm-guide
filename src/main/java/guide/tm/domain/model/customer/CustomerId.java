package guide.tm.domain.model.customer;

import java.util.UUID;

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

    public static CustomerId newId() {
        return new CustomerId(UUID.randomUUID().toString());
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

