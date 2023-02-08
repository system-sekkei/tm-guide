package guide.tm.infrastructure.datasource.product.bundle;

import guide.tm.domain.model.product.bundle.BundleProduct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
interface BundleProductMapper {

    List<BundleProduct> bundleProducts();
}
