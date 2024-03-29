package guide.tm.domain.model.allocation.stock;

import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.primitive.Quantity;
import guide.tm.domain.primitive.contact.Prefecture;

/**
 * 在庫
 */
public class Stock {

    ProductCode productCode;
    WareHouseCode wareHouseCode;
    Prefecture wareHousePrefecture;
    Quantity quantity;

    @Deprecated(since = "for myBatis")
    Stock() {
        this(new ProductCode(), new WareHouseCode(), Prefecture.北海道, new Quantity());
    }

    public Stock(ProductCode productCode, WareHouseCode wareHouseCode, Prefecture wareHousePrefecture, Quantity quantity) {
        this.productCode = productCode;
        this.wareHouseCode = wareHouseCode;
        this.wareHousePrefecture = wareHousePrefecture;
        this.quantity = quantity;
    }

    public WareHouseCode wareHouseCode() {
        return wareHouseCode;
    }

    public Quantity quantity() {
        return quantity;
    }
}
