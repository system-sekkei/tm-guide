package guide.tm.domain.model.shipping.content;

/**
 * 出荷
 */
public class Shipping {
    ShippingDate shippingDate;

    @Deprecated Shipping() {
        this(new ShippingDate());
    }

    public Shipping(ShippingDate shippingDate) {
        this.shippingDate = shippingDate;
    }
}
