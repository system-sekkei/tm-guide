package guide.tm.domain.model.product.summary;

/**
 * 商品区分
 */
public enum ProductType {
    個別,
    セット;

    public boolean is個別() {
        return this == 個別;
    }
}
