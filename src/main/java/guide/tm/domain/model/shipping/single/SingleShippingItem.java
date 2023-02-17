package guide.tm.domain.model.shipping.single;

import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.orderitem.number.SalesOrderItemNumber;

/**
 * 出荷指示
 */
public class SingleShippingItem {

    SalesOrderItemNumber salesOrderItemNumber;
    SingleProduct singleProduct;

    @Deprecated
    SingleShippingItem() {
        this(new SalesOrderItemNumber(), new SingleProduct());
    }

    public SingleShippingItem(SalesOrderItemNumber salesOrderItemNumber, SingleProduct singleProduct) {
        this.salesOrderItemNumber = salesOrderItemNumber;
        this.singleProduct = singleProduct;
    }

    public SingleProduct singleProduct() {
        return singleProduct;
    }

}
