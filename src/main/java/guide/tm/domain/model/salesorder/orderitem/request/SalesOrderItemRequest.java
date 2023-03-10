package guide.tm.domain.model.salesorder.orderitem.request;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.summary.ProductType;
import guide.tm.domain.primitive.Quantity;
import jakarta.validation.constraints.AssertTrue;

public class SalesOrderItemRequest {

    ProductName productName;
    ProductCode productCode;
    Quantity quantity;
    ProductType productType;

    public boolean isSingleProduct() {
        return productType.is個別();
    }

    public ProductName productName() {
        return productName;
    }

    public ProductCode productCode() {
        return productCode;
    }

    public Quantity quantity() {
        return quantity;
    }

    public ProductType productType() {
        return productType;
    }

    @AssertTrue(message = "1以上の数値を入力してください")
    boolean isQuantitySpecified() {
        return quantity.isGreaterEqualThan(new Quantity(1));
    }


    @AssertTrue(message = "商品を入力してください")
    boolean isProductSpecified() {
        return !productCode.isEmpty();
    }
}
