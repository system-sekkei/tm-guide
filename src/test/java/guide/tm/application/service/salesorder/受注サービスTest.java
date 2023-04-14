package guide.tm.application.service.salesorder;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.customer.CustomerName;
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

    Customer 顧客 = new Customer(new CustomerId("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"), new CustomerName("永門プロダクション"), new CustomerName("ナガトプロダクション"));

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

        assertTrue(登録された受注.customer().customerId().isSame(new CustomerId("39d3f994-6cd3-4a56-a2b5-d493f030cbc8")));
        assertEquals("永門プロダクション", 登録された受注.customer().name().toString());
        assertTrue(登録された受注.orderedDate().isEqual(new OrderedDate("2023-01-12")));

    }
}