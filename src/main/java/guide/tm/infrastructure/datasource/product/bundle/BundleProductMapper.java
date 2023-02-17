package guide.tm.infrastructure.datasource.product.bundle;

import guide.tm.domain.model.product.bundle.BundleProduct;
import guide.tm.domain.model.product.detail.ProductCode;
import guide.tm.domain.model.product.single.SingleProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface BundleProductMapper {

    List<BundleProduct> bundleProducts();

    void register(@Param("bundleProduct") BundleProduct bundleProduct);

    void registerCombination(
            @Param("productCode") ProductCode productCode,
            @Param("individualProduct") SingleProduct singleProduct);
}
