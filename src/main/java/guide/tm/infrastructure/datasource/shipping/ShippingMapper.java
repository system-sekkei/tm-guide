package guide.tm.infrastructure.datasource.shipping;

import guide.tm.domain.model.shipping.content.Shipping;
import guide.tm.domain.model.shipping.content.ShippingNumber;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.UUID;

@Mapper
interface ShippingMapper {

    void register(
            @Param("shipping") Shipping shipping,
            @Param("shippingNumber") UUID shippingNumber);

    Shipping shippingOf(@Param("shippingNumber") ShippingNumber shippingNumber);
}
