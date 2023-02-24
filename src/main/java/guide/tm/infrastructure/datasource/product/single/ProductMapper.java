package guide.tm.infrastructure.datasource.product.single;

import guide.tm.domain.model.product.single.SingleProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface ProductMapper {
    void register(@Param("product") SingleProduct singleProduct);

    List<SingleProduct> products();
}
