package guide.tm.domain.model.shipping.item;

public enum ShippingStatus {
    出荷指示済,
    出荷未指示,
    ;

    public boolean isInstructed() {
        return this == 出荷指示済;
    }
}
