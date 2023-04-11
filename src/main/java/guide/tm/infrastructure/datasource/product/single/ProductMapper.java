package guide.tm.infrastructure.datasource.product.single;

import guide.tm.domain.model.product.single.SingleProduct;
import guide.tm.domain.model.product.summary.ProductSearchCriteria;
import guide.tm.domain.model.product.summary.ProductSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface ProductMapper {
    void register(@Param("product") SingleProduct singleProduct);

    List<ProductSummary> searchSingleProducts(
            @Param("productSearchCriteria") ProductSearchCriteria productSearchCriteria);

    List<ProductSummary> searchBundleProducts(
            @Param("productSearchCriteria") ProductSearchCriteria productSearchCriteria);
}
