package guide.tm.infrastructure.datasource.warehouse;

import guide.tm.application.service.warehouse.WareHouseRepository;
import guide.tm.domain.model.allocation.warehouse.WareHouse;
import org.springframework.stereotype.Repository;

@Repository
public class WareHouseDataSource implements WareHouseRepository {

    WareHouseMapper wareHouseMapper;

    WareHouseDataSource(WareHouseMapper wareHouseMapper) {
        this.wareHouseMapper = wareHouseMapper;
    }

    @Override
    public void register(WareHouse wareHouse) {
        wareHouseMapper.register(wareHouse);
    }
}
