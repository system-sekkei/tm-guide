package guide.tm.application.setup;

import guide.tm.application.service.warehouse.WareHouseService;
import guide.tm.domain.model.allocation.warehouse.WareHouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class 倉庫準備 {
    @Autowired
    WareHouseService service;

    public void 倉庫のテストデータの準備(WareHouse 倉庫) {
        service.register(倉庫);
    }

    public void 倉庫のテストデータの準備(List<WareHouse> 倉庫リスト) {
        倉庫リスト.forEach(倉庫 -> service.register(倉庫));
    }
}
