package guide.tm.application.service.shipping;

import guide.tm.application.scenario.salesorder.SalesOrderScenario;
import guide.tm.application.service.allocation.AllocationService;
import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.allocation.bundle.BundleAllocations;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.warehouse.WareHouse;
import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerId;
import guide.tm.domain.model.customer.CustomerName;
import guide.tm.domain.model.customer.CustomerType;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.product.summary.ProductType;
import guide.tm.domain.model.salesorder.content.OrderedDate;
import guide.tm.domain.model.salesorder.content.Prefecture;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.content.ShippingAddress;
import guide.tm.domain.model.salesorder.order.SalesOrderId;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.request.SalesOrderItemRequest;
import guide.tm.domain.model.shipping.content.ShippingDate;
import guide.tm.domain.model.shipping.content.ShippingInstruction;
import guide.tm.domain.model.shipping.content.ShippingInstructionContent;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import guide.tm.domain.model.shipping.item.ShippingItems;
import guide.tm.domain.model.status.orderstatus.SalesOrderStatus;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.primitive.Quantity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class 出荷指示明細サービスTest {
    @Autowired
    ShippingItemService sut;
    @Autowired
    AllocationService allocationService;

    @Autowired
    SalesOrderScenario salesOrderScenario;

    SalesOrderId 受注ID;

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

    @Autowired
    guide.tm.application.setup.在庫準備 在庫準備;

    @Autowired
    guide.tm.application.setup.商品準備 商品準備;

    @Autowired
    guide.tm.application.setup.倉庫準備 倉庫準備;
    @Autowired
    guide.tm.application.setup.顧客準備 顧客準備;

    @Autowired
    SalesOrderService 受注Service;
    @Autowired
    SalesOrderItemService 受注明細Service;

    @Autowired
    ShippingService 出荷サービス;

    CustomerId 顧客番号 = new CustomerId("39d3f994-6cd3-4a56-a2b5-d493f030cbc8");
    Customer 顧客 = new Customer(顧客番号, new CustomerName("留美", "梅宮"), new CustomerName("ルミ", "ウメミヤ"), CustomerType.個人);

    @BeforeEach
    void setup() {
        顧客準備.顧客のテストデータの準備(顧客);

        WareHouse 東日本倉庫 = new WareHouse(new WareHouseCode("654321"), "東日本倉庫", "千葉県");
        WareHouse 西日本倉庫 = new WareHouse(new WareHouseCode("987655"), "西日本倉庫", "奈良県");
        WareHouse 中日本倉庫 = new WareHouse(new WareHouseCode("254i66"), "中日本倉庫", "静岡県");

        倉庫準備.倉庫のテストデータの準備(List.of(東日本倉庫, 西日本倉庫, 中日本倉庫));
        商品準備.商品のテストデータの準備(専用ボトル);
        商品準備.商品のテストデータの準備(専用ボトルキャップ);

        在庫準備.在庫のテストデータの準備(List.of(
                        new Stock(専用ボトル.code(), 東日本倉庫.wareHouseCode(), Prefecture.千葉県, new Quantity(23)),
                        new Stock(専用ボトル.code(), 西日本倉庫.wareHouseCode(), Prefecture.静岡県, new Quantity(8)),
                        new Stock(専用ボトル.code(), 中日本倉庫.wareHouseCode(), Prefecture.奈良県, new Quantity(38)),
                        new Stock(専用ボトルキャップ.code(), 東日本倉庫.wareHouseCode(), Prefecture.千葉県, new Quantity(2)),
                        new Stock(専用ボトルキャップ.code(), 西日本倉庫.wareHouseCode(), Prefecture.静岡県, new Quantity(60)),
                        new Stock(専用ボトルキャップ.code(), 中日本倉庫.wareHouseCode(), Prefecture.奈良県, new Quantity(18))
                )
        );

        SalesOrderContent 受注 = new SalesOrderContent(new SalesOrderNumber("12122323"), 顧客, new OrderedDate("2023-01-12"), new ShippingAddress(Prefecture.京都府, "伏見"));
        受注ID = 受注Service.registerSalesOrder(受注);
        SalesOrderItemRequest 受注明細_専用ボトル登録リクエスト =
                new SalesOrderItemRequest(専用ボトル.name(), 専用ボトル.code(),  new Quantity(42), ProductType.個別);
        SalesOrderItemRequest 受注明細_専用ボトルキャップ登録リクエスト =
                new SalesOrderItemRequest(専用ボトルキャップ.name(), 専用ボトルキャップ.code(), new Quantity(23), ProductType.個別);

        受注明細Service.register(受注ID, 受注明細_専用ボトル登録リクエスト);
        受注明細Service.register(受注ID, 受注明細_専用ボトルキャップ登録リクエスト);
    }

    @Test
    void 出荷明細を登録する() {
        // given:
        ShippingDate 出荷日 = new ShippingDate(LocalDate.of(2023, Month.MARCH, 2));
        ShippingInstructionContent 出荷 = new ShippingInstructionContent(受注ID, 出荷日);

        // and: "引当して、結果を登録する"
        SalesOrderStatus 受注明細状況 = salesOrderScenario.status(受注ID);
        allocationService.allocateSalesOrder(受注明細状況, 受注ID);

        // and: "引当を取得できる"
        SingleAllocations 個別商品引当結果 = allocationService.singleAllocationsOf(受注ID);
        BundleAllocations セット商品引当結果 = allocationService.bundleAllocations(受注ID);

        ShippingNumber 出荷番号 = 出荷サービス.register(
                new ShippingInstruction(
                        new ShippingInstructionContent(受注ID, new ShippingDate(LocalDate.of(2023, 3, 1))),
                        個別商品引当結果,
                        セット商品引当結果
                ));


        // when: "出荷明細を取得する"
        ShippingItems shippingItems = sut.shippingItems(受注ID);
        then:
        // "出荷明細を5件取得できる"
        assertEquals(5, shippingItems.singleShippingItems().list().size());

        //and: "専用ボトルの出荷明細は3件"
        assertEquals(
                3,
                shippingItems.singleShippingItems().list().stream().filter(it -> it.singleProduct().code().isSame(new ProductCode("821009"))).count()
        );

        // and: "専用ボトルキャップの出荷明細は2件"
        assertEquals(
                2,
                shippingItems.singleShippingItems().list().stream().filter(it -> it.singleProduct().code().isSame(new ProductCode("821010"))).count()
        );
    }

}