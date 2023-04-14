package guide.tm.domain.model.allocation.stock;

import guide.tm.domain.model.allocation.location.AllocatedLocations;
import guide.tm.domain.model.allocation.warehouse.WareHouseCode;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.salesorder.content.ShippingAddress;
import guide.tm.domain.primitive.Quantity;
import guide.tm.domain.primitive.contact.Prefecture;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class 在庫のリストTest {

    Stocks sut;

    Stock 千葉県の在庫 = new Stock(new ProductCode("821010"), new WareHouseCode("654321"), Prefecture.千葉県, new Quantity(10));
    Stock 静岡県の在庫 = new Stock(new ProductCode("821010"), new WareHouseCode("987655"), Prefecture.静岡県, new Quantity(8));
    Stock 奈良県の在庫 = new Stock(new ProductCode("821010"), new WareHouseCode("254i66"), Prefecture.奈良県, new Quantity(13));

    @BeforeEach
    void 在庫の準備() {
        sut = new Stocks(List.of(千葉県の在庫, 静岡県の在庫, 奈良県の在庫));
    }

    @Nested
    class ソート {
        @Test
        void 届け先_三重県に近い順にソートする() {
            Stocks 在庫 = sut.sortByCloserTo(new ShippingAddress(Prefecture.三重県, "鈴鹿市"));
            assertTrue(在庫.list.get(0).wareHouseCode.isSame(奈良県の在庫.wareHouseCode));
            assertTrue(在庫.list.get(1).wareHouseCode.isSame(静岡県の在庫.wareHouseCode));
            assertTrue(在庫.list.get(2).wareHouseCode.isSame(千葉県の在庫.wareHouseCode));
        }

        @Test
        void 届け先_青森県に近い順にソートする() {
            Stocks 在庫 = sut.sortByCloserTo(new ShippingAddress(Prefecture.青森県, "鈴鹿市"));
            assertTrue(在庫.list.get(0).wareHouseCode.isSame(千葉県の在庫.wareHouseCode));
            assertTrue(在庫.list.get(1).wareHouseCode.isSame(静岡県の在庫.wareHouseCode));
            assertTrue(在庫.list.get(2).wareHouseCode.isSame(奈良県の在庫.wareHouseCode));
        }

        @Test
        void 届け先_愛知県に近い順にソートする() {
            Stocks 在庫 = sut.sortByCloserTo(new ShippingAddress(Prefecture.愛知県, "鈴鹿市"));
            assertTrue(在庫.list.get(0).wareHouseCode.isSame(静岡県の在庫.wareHouseCode));
            assertTrue(在庫.list.get(1).wareHouseCode.isSame(千葉県の在庫.wareHouseCode));
            assertTrue(在庫.list.get(2).wareHouseCode.isSame(奈良県の在庫.wareHouseCode));
        }

    }

    @Nested
    class 引当 {

        @Test
        @DisplayName("1つの倉庫で引当できる場合,引当が1つ作成される")
        void 一倉庫から引当する() {
            //"数量10の引当を行う"
            AllocatedLocations allocate = sut.allocate(new Quantity(10));
            // "引当は1つ作成される"
            assertEquals(1, allocate.list().size());
            // "引当倉庫コードは654321"
            assertTrue(allocate.list().get(0).wareHouseCode().isSame(千葉県の在庫.wareHouseCode));
            //  "引当数量は10"
            assertTrue(allocate.list().get(0).allocatedQuantity().isEqual(new Quantity(10)));
        }


        @Test
        @DisplayName("2つの倉庫で引当できる場合,引当が2つ作成される")
        void 二倉庫から引当する() {
            //when: "数量15の引当を行う"
            AllocatedLocations allocate = sut.allocate(new Quantity(15));

            // then: "引当は2つ作成される"
            assertEquals(2, allocate.list().size());
            // and: "引当倉庫コードは654321"
            assertTrue(allocate.list().get(0).wareHouseCode().isSame(千葉県の在庫.wareHouseCode));
            // and: "引当数量は10"
            assertTrue(allocate.list().get(0).allocatedQuantity().isEqual(new Quantity(10)));
            // and: "引当倉庫コードは987655"
            assertTrue(allocate.list().get(1).wareHouseCode().isSame(静岡県の在庫.wareHouseCode));
            // and: "引当数量は5"
            assertTrue(allocate.list().get(1).allocatedQuantity().isEqual(new Quantity(5)));

        }

        @Test
        @DisplayName("在庫が不足している場合、全倉庫数分の引当が作成される")
        void 在庫が不足している() {
            // when: "数量35の引当を行う"
            AllocatedLocations allocate = sut.allocate(new Quantity(35));

            //then: "引当は3つ作成される"
            assertEquals(3, allocate.list().size());
            // and: "引当倉庫コードは654321"
            assertTrue(allocate.list().get(0).wareHouseCode().isSame(千葉県の在庫.wareHouseCode));
            // and: "引当数量は10"
            assertTrue(allocate.list().get(0).allocatedQuantity().isEqual(new Quantity(10)));

            // and: "引当倉庫コードは987655"
            assertTrue(allocate.list().get(1).wareHouseCode().isSame(静岡県の在庫.wareHouseCode));
            // and: "引当数量は8"
            assertTrue(allocate.list().get(1).allocatedQuantity().isEqual(new Quantity(8)));

            // and: "引当倉庫コードは254i66"
            assertTrue(allocate.list().get(2).wareHouseCode().isSame(奈良県の在庫.wareHouseCode));
            // and: "引当数量は8"
            assertTrue(allocate.list().get(2).allocatedQuantity().isEqual(new Quantity(13)));
        }
    }
}