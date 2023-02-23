package guide.tm.domain.model.shipping.content;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.salesorder.content.OrderedDate;

/**
 * 出荷指示
 */
public class ShippingInstructionSummary {
    ShippingNumber shippingNumber;
    ShippingInstructionContent shippingInstructionContent;
    OrderedDate orderedDate;
    Customer customer;

    public ShippingNumber shippingNumber() {
        return shippingNumber;
    }

    public ShippingInstructionContent shippingInstructionContent() {
        return shippingInstructionContent;
    }

    public OrderedDate orderedDate() {
        return orderedDate;
    }

    public Customer customer() {
        return customer;
    }
}
