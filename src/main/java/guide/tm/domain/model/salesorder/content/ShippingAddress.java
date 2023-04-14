package guide.tm.domain.model.salesorder.content;

import guide.tm.domain.primitive.contact.Prefecture;
import jakarta.validation.constraints.AssertFalse;

/**
 * 届け先住所
 */
public class ShippingAddress {
    Prefecture prefecture;
    String addressLine;

    public ShippingAddress() {
        this(Prefecture.北海道, "");
    }

    public ShippingAddress(Prefecture prefecture, String addressLine) {
        this.prefecture = prefecture;
        this.addressLine = addressLine;
    }

    public Prefecture prefecture() {
        return prefecture;
    }

    public String addressLine() {
        return addressLine;
    }

    @Override
    public String toString() {
        return "%s %s".formatted(prefecture.name(), addressLine);
    }

    boolean prefectureSpecified;
    @AssertFalse(message = "都道府県を選択してください")
    boolean isPrefectureSpecified() {
        return prefecture == null;
    }

    boolean addressLineSpecified;
    @AssertFalse(message = "住所を入力してください")
    boolean isAddressLineSpecified() {
        return addressLine.isEmpty();
    }

}
