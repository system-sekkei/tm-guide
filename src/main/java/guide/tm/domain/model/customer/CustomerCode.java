package guide.tm.domain.model.customer;

/**
 * 顧客コード
 */
public class CustomerCode {
    String value;

    CustomerCode() {
        this("");
    }

    public CustomerCode(String value) {
        this.value = value;
    }
}

