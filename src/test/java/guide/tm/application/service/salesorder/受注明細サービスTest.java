package guide.tm.application.service.salesorder;

import guide.tm.application.fixture.商品Fixture;
import guide.tm.application.fixture.顧客Fixture;
import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerName;
import guide.tm.domain.model.customer.CustomerNumber;
import guide.tm.domain.model.customer.CustomerType;
import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.product.bundle.BundleProductItems;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.content.OrderedDate;
import guide.tm.domain.model.salesorder.content.Prefecture;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.content.ShippingAddress;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItem;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.bundle.BundleProductOrderItems;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent;
import guide.tm.domain.model.salesorder.orderitem.single.SingleProductOrderItems;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.primitive.Quantity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Transactional
class 受注明細サービスTest {

    @Autowired
    SalesOrderItemService sut;

    @Autowired
    SalesOrderService salesOrderService;

    @Autowired
    商品Fixture 商品準備;

    @Autowired
    顧客Fixture 顧客準備;

    @Nested
    class 個別商品 {

        SingleProduct 専用ボトル = new SingleProduct(
                new ProductCode("821009"),
                new ProductName("専用ボトル"),
                new UnitPrice(4400),
                TaxRateType.通常税率
        );

        SingleProduct 専用ボトルキャップ = new SingleProduct(
                new ProductCode("821010"),
                new ProductName("専用ボトルキャップ"),
                new UnitPrice(1200),
                TaxRateType.通常税率
        );

        Customer 顧客 = new Customer(
                new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"),
                new CustomerName("梅宮 留美"),
                CustomerType.個人);


        @BeforeEach
        void setup() {
            顧客準備.顧客のテストデータの準備(顧客);
            商品準備.商品のテストデータの準備(List.of(専用ボトル, 専用ボトルキャップ));
        }

        @Test
        void 受注明細を登録する() {
            // given:
            SalesOrderContent 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"), new ShippingAddress(Prefecture.埼玉県, "さいたま市"));
            SingleOrderItemContent 受注明細_専用ボトル = new SingleOrderItemContent(専用ボトル, new Quantity(1));
            SingleOrderItemContent 受注明細_専用ボトルキャップ = new SingleOrderItemContent(専用ボトルキャップ, new Quantity(2));

            // when: "受注明細を登録する"
            SalesOrderNumber 受注番号 = salesOrderService.registerSalesOrder(受注);
            sut.register(受注番号, 受注明細_専用ボトル);
            sut.register(受注番号, 受注明細_専用ボトルキャップ);

            // then: "受注明細を取得する"
            SingleProductOrderItems 登録された受注明細 = sut.singleProductOrderItemsOf(受注番号);

            assertEquals(2, 登録された受注明細.list().size());

            // and: "専用ボトルの受注明細の受注数は1"
            SingleOrderItemContent 専用ボトルの受注明細 =
                    登録された受注明細.list().stream()
                            .filter(it -> it.product().code().isSame(new ProductCode("821009")))
                            .findFirst()
                            .orElseThrow()
                            .singleOrderItemContent();
            assertTrue(専用ボトルの受注明細.quantity().isEqual(new Quantity(1)));

            // and: "専用ボトルキャップの受注明細の受注数は2"
            SingleOrderItemContent 専用ボトルキャップの受注明細 =
                    登録された受注明細.list().stream()
                            .filter(it -> it.product().code().isSame(new ProductCode("821010")))
                            .findFirst()
                            .orElseThrow()
                            .singleOrderItemContent();
            assertTrue(専用ボトルキャップの受注明細.quantity().isEqual(new Quantity(2)));

        }
    }

    @Nested
    class セット商品 {
        SingleProduct 尾西のご飯 = new SingleProduct(
                new ProductCode("821009"),
                new ProductName("尾西のご飯"),
                new UnitPrice(4400),
                TaxRateType.軽減税率
        );

        SingleProduct サタケのマジックパスタ = new SingleProduct(
                new ProductCode("821010"),
                new ProductName("サタケのマジックパスタ"),
                new UnitPrice(1200),
                TaxRateType.軽減税率
        );

        BundleProduct 非常食セット = new BundleProduct(
                new ProductCode("9807987"),
                new ProductName("非常食セット_受注明細"),
                new BundleProductItems(List.of(尾西のご飯, サタケのマジックパスタ)),
                new UnitPrice(5200),
                TaxRateType.軽減税率
        );

        Customer 顧客 = new Customer(
                new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"),
                new CustomerName("梅宮 留美"),
                CustomerType.個人);

        @BeforeEach
        void setup() {
            顧客準備.顧客のテストデータの準備(顧客);
            商品準備.商品のテストデータの準備(List.of(尾西のご飯, サタケのマジックパスタ));
            商品準備.セット商品のテストデータ準備(List.of(非常食セット));
        }

        @Test
        void セット品受注明細を登録する() {
            //given:
            SalesOrderContent 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"), new ShippingAddress(Prefecture.大分県, "別府"));
            BundleProductOrderItemContent 非常食セット_受注明細 = new BundleProductOrderItemContent(非常食セット, new Quantity(1));

            // when: "セット品受注明細を登録する"
            SalesOrderNumber 受注番号 = salesOrderService.registerSalesOrder(受注);
            sut.registerBundleProductOrderItem(受注番号, 非常食セット_受注明細);

            // then: "セット品受注明細を取得する"
            BundleProductOrderItems 登録された受注明細 = sut.bundleProductOrderItemsOf(受注番号);

            assertEquals(1, 登録された受注明細.list().size());

            //and: "非常食セット_受注明細の受注明細の受注数は1"
            BundleProductOrderItem 非常食セット受注明細 = 登録された受注明細.list().stream().filter(it -> it.bundleProduct().code().isSame(new ProductCode("9807987"))).findFirst().orElseThrow();
            assertTrue(非常食セット受注明細.quantity().isEqual(new Quantity(1)));

        }
    }
}