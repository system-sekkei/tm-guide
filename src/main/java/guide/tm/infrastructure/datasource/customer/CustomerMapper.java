package guide.tm.infrastructure.datasource.customer;

import guide.tm.domain.model.customer.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
interface CustomerMapper {

    void register(@Param("customer") Customer customer);
}
