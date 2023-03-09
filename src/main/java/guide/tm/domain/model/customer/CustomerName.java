package guide.tm.domain.model.customer;

/**
 * 顧客名称
 */
public class CustomerName {
    String firstName;
    String lastName;

    CustomerName() {
        this("", "");
    }

    public CustomerName(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "%s %s".formatted(lastName, firstName);
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }
}
