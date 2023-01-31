package guide.tm.domain.model.shipping.content;

import guide.tm.domain.model.customer.CustomerNumber;
import guide.tm.domain.model.shipping.company.ShippingCompanyCode;

/**
 * 出荷
 */
public class Shipping {
    CustomerNumber customerNumber;
    ShippingDate shippingDate;
    ShippingCompanyCode shippingCompanyCode;

    @Deprecated Shipping() {
        this(new CustomerNumber(), new ShippingDate(), new ShippingCompanyCode());
    }

    public Shipping(CustomerNumber customerNumber, ShippingDate shippingDate, ShippingCompanyCode shippingCompanyCode) {
        this.customerNumber = customerNumber;
        this.shippingDate = shippingDate;
        this.shippingCompanyCode = shippingCompanyCode;
    }
}
