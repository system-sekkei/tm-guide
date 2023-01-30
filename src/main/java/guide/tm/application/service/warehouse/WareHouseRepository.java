package guide.tm.application.service.warehouse;

import guide.tm.domain.model.allocation.warehouse.WareHouse;

public interface WareHouseRepository {
    void register(WareHouse wareHouse);
}
