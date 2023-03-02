package guide.tm.application.service.allocation;

import guide.tm.application.fixture.倉庫Fixture;
import guide.tm.application.fixture.商品Fixture;
import guide.tm.application.fixture.在庫Fixture;
import guide.tm.application.fixture.顧客Fixture;
import guide.tm.application.service.salesorder.SalesOrderItemService;
import guide.tm.application.service.salesorder.SalesOrderService;
import guide.tm.domain.model.allocation.single.SingleAllocation;
import guide.tm.domain.model.allocation.single.SingleAllocations;
import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.allocation.warehouse.WareHouse;
import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerName;
import guide.tm.domain.model.customer.CustomerNumber;
import guide.tm.domain.model.customer.CustomerType;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.detail.ProductName;
import guide.tm.domain.model.product.price.UnitPrice;
import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.salesorder.content.OrderedDate;
import guide.tm.domain.model.salesorder.content.Prefecture;
import guide.tm.domain.model.salesorder.content.SalesOrderContent;
import guide.tm.domain.model.salesorder.content.ShippingAddress;
import guide.tm.domain.model.salesorder.order.SalesOrderNumber;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItem;
import guide.tm.domain.model.salesorder.orderitem.single.SingleOrderItemContent;
import guide.tm.domain.model.shipping.status.ShippingStatus;
import guide.tm.domain.model.status.single.SingleOrderItemStatus;
import guide.tm.domain.model.tax.context.TaxRateType;
import guide.tm.domain.primitive.Quantity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class 引当サービスTest {

    @Autowired
    AllocationService sut;

    SalesOrderNumber 受注番号;

    SingleProduct 専用ボトル = new SingleProduct(
            new ProductCode("821009"),
            new ProductName("専用ボトル"),
            new UnitPrice(4400),
            TaxRateType.通常税率
    );

    @Autowired
    在庫Fixture 在庫準備;

    @Autowired
    商品Fixture 商品準備;

    @Autowired
    倉庫Fixture 倉庫準備;
    @Autowired
    顧客Fixture 顧客準備;

    @Autowired
    SalesOrderService 受注Service;
    @Autowired
    SalesOrderItemService 受注明細Service;

    SingleOrderItemContent 受注明細_専用ボトル = new SingleOrderItemContent(専用ボトル, new Quantity(42));

    @BeforeEach
    void setup() {
        Customer 顧客 = new Customer(new CustomerNumber("39d3f994-6cd3-4a56-a2b5-d493f030cbc8"), new CustomerName("梅宮 留美"), CustomerType.個人);
        顧客準備.顧客のテストデータの準備(顧客);

        WareHouse 東日本倉庫 = new WareHouse(new WareHouseCode("654321"), "東日本倉庫", "千葉県");
        WareHouse 西日本倉庫 = new WareHouse(new WareHouseCode("987655"), "西日本倉庫", "奈良県");
        WareHouse 中日本倉庫 = new WareHouse(new WareHouseCode("254i66"), "中日本倉庫", "静岡県");

        倉庫準備.倉庫のテストデータの準備(List.of(東日本倉庫, 西日本倉庫, 中日本倉庫));
        商品準備.商品のテストデータの準備(専用ボトル);
        在庫準備.在庫のテストデータの準備(
                List.of(
                        new Stock(new ProductCode("821009"), new WareHouseCode("654321"), Prefecture.千葉県, new Quantity(10)),
                        new Stock(new ProductCode("821009"), new WareHouseCode("987655"), Prefecture.静岡県, new Quantity(8)),
                        new Stock(new ProductCode("821009"), new WareHouseCode("254i66"), Prefecture.奈良県, new Quantity(13))
                )
        );
        SalesOrderContent 受注 = new SalesOrderContent(顧客, new OrderedDate("2023-01-12"), new ShippingAddress(Prefecture.三重県, "津"));
        受注番号 = 受注Service.registerSalesOrder(受注);
        受注明細Service.register(受注番号, 受注明細_専用ボトル);
    }

    @Test
    void 個別商品の引当を登録する() {
        SingleOrderItem 受注明細 = 受注明細Service.singleProductOrderItemsOf(受注番号).list().get(0);
        SingleOrderItemStatus 受注明細状況 = new SingleOrderItemStatus(受注明細, new SingleAllocation(), ShippingStatus.出荷未指示);

        // when: "引当して、結果を登録する"
        sut.allocate(受注明細状況, 受注番号, new ShippingAddress(Prefecture.三重県, "津"));

        // then: "引当を取得できる"
        SingleAllocations 引当結果 = sut.singleAllocationsOf(受注番号);
        // and: "引当を1件取得する"
        assertEquals(1, 引当結果.list().size());
        // and: "引当場所を3件取得する"
        assertEquals(3, 引当結果.list().get(0).productAllocation().allocatedLocations().list().size());

    }
}