package guide.tm.domain.model.salesorder.content;

import guide.tm.domain.primitive.Amount;

import java.math.BigDecimal;

/**
 * 送料
 *
 * - 税抜き価格が5000円以上の場合、無料
 * - 税抜き価格が5000円未満の場合、2000円
 */
public class ShippingFee {

    Amount amountExcludingTax;

    public ShippingFee(Amount amountExcludingTax) {
        this.amountExcludingTax = amountExcludingTax;
    }

    public Amount amount() {
        if (amountExcludingTax.isGreaterThan(new Amount(new BigDecimal("5000")))) {
            return new Amount(BigDecimal.ZERO);
        }
        return new Amount(new BigDecimal("2000"));
    }
}

