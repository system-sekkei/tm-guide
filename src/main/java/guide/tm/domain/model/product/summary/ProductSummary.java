package guide.tm.domain.model.product.summary;

import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;

/**
 * 商品サマリー
 */
public class ProductSummary {
    ProductCode productCode;
    ProductName productName;
    UnitPrice unitPrice;
    ProductType productType;
}
