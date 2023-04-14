package guide.tm.domain.model.customer;

import guide.tm.domain.model.customer.contact.Contact;

/**
 * 顧客
 */
public class Customer {
    CustomerId customerId;
    CustomerName customerName;
    Contact contact;

    public Customer() {
        this(new CustomerId(""), new CustomerName(), new Contact());
    }

    public Customer(CustomerId customerId, CustomerName customerName, Contact contact) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.contact = contact;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public CustomerName customerName() {
        return customerName;
    }

    public Name name() {
        return customerName.name;
    }

    public boolean isSame(Customer other) {
        return customerId.isSame(other.customerId);
    }
}
