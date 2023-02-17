package guide.tm.domain.model.allocation.bundle;

/**
 * セット商品の引当番号
 */
public class BundleAllocationNumber {
    String value;

    BundleAllocationNumber() {
        this("");
    }

    public BundleAllocationNumber(String value) {
        this.value = value;
    }

}
