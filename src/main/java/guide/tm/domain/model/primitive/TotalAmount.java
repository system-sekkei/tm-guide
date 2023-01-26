package guide.tm.domain.model.primitive;

import java.util.Set;

/**
 * 合計金額
 */
public class TotalAmount {
    Set<Amount> set;

    public TotalAmount(Set<Amount> set) {
        this.set = set;
    }

    /**
     * 合計金額
     */
    public Amount total() {
        return set.stream().reduce(Amount::add).orElse(new Amount());
    }

    /**
     * それぞれに率を掛け合わせて合計金額を算出する
     */
    public Amount totalOfEach(Rate rate) {
        return set.stream()
                .map(amount -> amount.multiply(rate))
                .reduce(Amount::add).orElse(new Amount());
    }
}
