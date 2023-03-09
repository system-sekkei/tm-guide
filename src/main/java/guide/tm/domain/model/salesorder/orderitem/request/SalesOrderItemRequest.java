package guide.tm.domain.model.salesorder.orderitem.request;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.summary.ProductType;
import guide.tm.domain.primitive.Quantity;

public class SalesOrderItemRequest {
    ProductCode productCode;
    Quantity quantity;
    ProductType productType;

    public boolean isSingleProduct() {
        return productType.is個別();
    }

    public ProductCode productCode() {
        return productCode;
    }

    public Quantity quantity() {
        return quantity;
    }
}
