package guide.tm.application.service.salesorder;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerName;
import guide.tm.domain.model.customer.CustomerNumber;
import guide.tm.domain.model.customer.CustomerType;
import guide.tm.domain.model.salesorder.content.OrderedDate;
import guide.tm.domain.model.salesorder.content.Prefecture;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.content.ShippingAddress;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class 受注サービスTest {
    @Autowired
    SalesOrderService sut;

    @Autowired
    guide.tm.application.setup.顧客準備 顧客準備;

    Customer 顧客 = new Customer(new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"), new CustomerName("留美", "梅宮"), new CustomerName("ルミ", "ウメミヤ"), CustomerType.個人);

    @BeforeEach
    void テストデータの準備() {
        顧客準備.顧客のテストデータの準備(顧客);
    }

    @Test
    void 受注を登録する() {
        SalesOrderContent 受注 = new SalesOrderContent(new SalesOrderNumber("98789878"), 顧客, new OrderedDate("2023-01-12"), new ShippingAddress(Prefecture.大分県, "九重"));

        //"受注を登録する"
        SalesOrderId 受注ID = sut.registerSalesOrder(受注);

        // "受注を取得する"
        SalesOrderContent 登録された受注 = sut.salesOrderOf(受注ID);

        assertTrue(登録された受注.customer().code().isSame(new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8")));
        assertEquals("梅宮 留美", 登録された受注.customer().name().toString());
        assertTrue(登録された受注.orderedDate().isEqual(new OrderedDate("2023-01-12")));

    }
}