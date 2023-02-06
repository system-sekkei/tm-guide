package guide.tm.infrastructure.datasource.customer;

import guide.tm.domain.model.customer.Customer;
import guide.tm.domain.model.customer.CustomerSummary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
interface CustomerMapper {

    void register(@Param("customer") Customer customer);

    List<CustomerSummary> summaries();
}
