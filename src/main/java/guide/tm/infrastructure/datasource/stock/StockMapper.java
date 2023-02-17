package guide.tm.infrastructure.datasource.stock;

import guide.tm.domain.model.allocation.stock.Stock;
import guide.tm.domain.model.product.single.SingleProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StockMapper {
    List<Stock> stocksOf(@Param("product") SingleProduct singleProduct);

    void register(@Param("stock") Stock stock);
}
