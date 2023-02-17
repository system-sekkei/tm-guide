package guide.tm.domain.model.customer;

import java.util.List;

/**
 * 顧客の一覧
 */
public class Customers {
    List<Customer> list;

    public Customers(List<Customer> list) {
        this.list = list;
    }

    public List<Customer> list() {
        return list;
    }
}
