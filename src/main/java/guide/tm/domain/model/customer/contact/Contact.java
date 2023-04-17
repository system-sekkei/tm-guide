package guide.tm.domain.model.customer.contact;

import guide.tm.domain.primitive.contact.Address;
import guide.tm.domain.primitive.contact.PhoneNumber;

/**
 * 顧客連絡先
 */
public class Contact {
    Address address;
    PhoneNumber phoneNumber;
    String personInCharge;

    public Contact() {
        this(new Address(), new PhoneNumber(), "");
    }

    public Contact(Address address, PhoneNumber phoneNumber, String personInCharge) {
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.personInCharge = personInCharge;
    }

    public Address address() {
        return address;
    }

    public PhoneNumber phoneNumber() {
        return phoneNumber;
    }

    public String personInCharge() {
        return personInCharge;
    }
}
