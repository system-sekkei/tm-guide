package guide.tm.application.service.warehouse;

import guide.tm.domain.model.allocation.warehouse.WareHouse;
import org.springframework.stereotype.Service;

@Service
public class WareHouseService {

    WareHouseRepository wareHouseRepository;

    WareHouseService(WareHouseRepository wareHouseRepository) {
        this.wareHouseRepository = wareHouseRepository;
    }

    /**
     * 倉庫を登録する
     */
    public void register(WareHouse wareHouse) {
        wareHouseRepository.register(wareHouse);
    }
}
