package guide.tm.infrastructure.datasource.product;

import guide.tm.domain.model.product.Product;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
interface ProductMapper {
    void register(@Param("product") Product product);
}
