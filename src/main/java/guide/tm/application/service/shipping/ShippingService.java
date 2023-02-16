package guide.tm.application.service.shipping;

import guide.tm.domain.model.allocation.salesorder.bundle.BundleOrderItemAllocations;
import guide.tm.domain.model.allocation.salesorder.single.SingleOrderItemAllocations;
import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.springframework.stereotype.Service;

/**
 * 出荷指示サービス
 */
@Service
public class ShippingService {
    ShippingRepository shippingRepository;

    ShippingService(ShippingRepository shippingRepository) {
        this.shippingRepository = shippingRepository;
    }

    /**
     * 出荷指示を登録する
     */
    public ShippingNumber register(
            Shipping shipping,
            SingleOrderItemAllocations singleOrderItemAllocations,
            BundleOrderItemAllocations bundleOrderItemAllocations) {
        return shippingRepository.register(shipping, singleOrderItemAllocations, bundleOrderItemAllocations);
    }

    /**
     * 出荷を取得する
     */
    public Shipping shippingOf(ShippingNumber shippingNumber) {
        return shippingRepository.shippingOf(shippingNumber);
    }

}
