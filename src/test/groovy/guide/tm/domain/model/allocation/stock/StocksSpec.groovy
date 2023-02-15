package guide.tm.domain.model.allocation.stock


import guide.tm.domain.model.allocation.location.AllocatedLocations
import guide.tm.domain.model.allocation.warehouse.WareHouseCode
import guide.tm.domain.model.primitive.Quantity
import guide.tm.domain.model.product.detail.ProductCode
import spock.lang.Specification

class StocksSpec extends Specification {

    Stocks sut

    void setup() {
        sut = new Stocks(
                List.of(
                        new Stock(new ProductCode("821010"), new WareHouseCode("654321"), new Quantity(10)),
                        new Stock(new ProductCode("821010"), new WareHouseCode("987655"), new Quantity(8)),
                        new Stock(new ProductCode("821010"), new WareHouseCode("254i66"), new Quantity(13))
                )
        )
    }

    def "1つの倉庫で引当できる場合,引当が1つ作成される"() {
        when: "数量10の引当を行う"
        AllocatedLocations allocate = sut.allocate(new Quantity(10))

        then: "引当は1つ作成される"
        assert allocate.list().size() == 1
        and: "引当倉庫コードは654321"
        assert allocate.list().get(0).wareHouseCode.value == "654321"
        and: "引当数量は10"
        assert allocate.list().get(0).allocatedQuantity.value == 10
    }

    def "2つの倉庫で引当できる場合,引当が2つ作成される"() {
        when: "数量15の引当を行う"
        AllocatedLocations allocate = sut.allocate(new Quantity(15))

        then: "引当は2つ作成される"
        assert allocate.list().size() == 2
        and: "引当倉庫コードは654321"
        assert allocate.list().get(0).wareHouseCode.value == "654321"
        and: "引当数量は10"
        assert allocate.list().get(0).allocatedQuantity.value == 10
        and: "引当倉庫コードは987655"
        assert allocate.list().get(1).wareHouseCode.value == "987655"
        and: "引当数量は5"
        assert allocate.list().get(1).allocatedQuantity.value == 5

    }

    def "在庫が不足している場合、全倉庫数分の引当が作成される"() {
        when: "数量25の引当を行う"
        AllocatedLocations allocate = sut.allocate(new Quantity(35))

        then: "引当は2つ作成される"
        assert allocate.list().size() == 3
        and: "引当倉庫コードは654321"
        assert allocate.list().get(0).wareHouseCode.value == "654321"
        and: "引当数量は10"
        assert allocate.list().get(0).allocatedQuantity.value == 10

        and: "引当倉庫コードは987655"
        assert allocate.list().get(1).wareHouseCode.value == "987655"
        and: "引当数量は5"
        assert allocate.list().get(1).allocatedQuantity.value == 8

        and: "引当倉庫コードは254i66"
        assert allocate.list().get(2).wareHouseCode.value == "254i66"
        and: "引当数量は13"
        assert allocate.list().get(2).allocatedQuantity.value == 13
    }

}
