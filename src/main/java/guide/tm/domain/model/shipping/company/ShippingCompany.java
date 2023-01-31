package guide.tm.domain.model.shipping.company;

/**
 * 運送会社
 */
public class ShippingCompany {
    ShippingCompanyCode code;
    String name;

    public ShippingCompany(ShippingCompanyCode code, String name) {
        this.code = code;
        this.name = name;
    }
}
