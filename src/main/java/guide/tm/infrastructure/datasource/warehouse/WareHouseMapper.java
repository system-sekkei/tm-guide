package guide.tm.infrastructure.datasource.warehouse;

import guide.tm.domain.model.allocation.warehouse.WareHouse;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
interface WareHouseMapper {
    void register(@Param("wareHouse") WareHouse wareHouse);
}
