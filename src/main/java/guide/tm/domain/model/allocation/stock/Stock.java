package guide.tm.domain.model.allocation.stock;

import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.primitive.Quantity;
import guide.tm.domain.model.product.ProductCode;

/**
 * 在庫
 */
public class Stock {

    ProductCode productCode;
    WareHouseCode wareHouseCode;
    Quantity quantity;

    @Deprecated(since = "for myBatis")
    Stock() {
        this(new ProductCode(), new WareHouseCode(), new Quantity());
    }

    public Stock(ProductCode productCode, WareHouseCode wareHouseCode, Quantity quantity) {
        this.productCode = productCode;
        this.wareHouseCode = wareHouseCode;
        this.quantity = quantity;
    }
}