package guide.tm.domain.model.allocation.bundle;

public class BundleAllocationNumber {
    String value;

    @Deprecated BundleAllocationNumber() {
        this("");
    }

    public BundleAllocationNumber(String value) {
        this.value = value;
    }

}
