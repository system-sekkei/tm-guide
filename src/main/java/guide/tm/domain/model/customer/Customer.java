package guide.tm.domain.model.customer;

import guide.tm.domain.model.customer.contact.Contact;

/**
 * 顧客
 */
public class Customer {
    CustomerId customerId;
    CustomerNumber customerNumber;
    CustomerName customerName;
    Contact contact;

    public Customer() {
        this(new CustomerId(), new CustomerName(), new CustomerNumber(), new Contact());
    }

    public Customer(CustomerId customerId, CustomerName customerName, CustomerNumber customerNumber, Contact contact) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerNumber = customerNumber;
        this.contact = contact;
    }

    public CustomerId customerId() {
        return customerId;
    }

    public CustomerNumber customerNumber() {
        return customerNumber;
    }

    public CustomerName customerName() {
        return customerName;
    }

    public Name name() {
        return customerName.name;
    }

    public Contact contact() {
        return contact;
    }

    public boolean isSame(Customer other) {
        return customerId.isSame(other.customerId);
    }
}
