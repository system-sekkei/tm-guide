package guide.tm.infrastructure.datasource.product;

import guide.tm.domain.model.product.individual.IndividualProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface ProductMapper {
    void register(@Param("product") IndividualProduct individualProduct);

    List<IndividualProduct> products();
}
