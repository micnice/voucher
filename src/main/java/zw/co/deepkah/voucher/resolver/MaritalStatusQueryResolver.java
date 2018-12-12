package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Arrays;
import zw.co.deepkah.voucher.document.MaritalStatus;

import java.util.List;

@Component
public class MaritalStatusQueryResolver implements GraphQLQueryResolver {


    public List<MaritalStatus>  getMaritalStatusList(){
        return java.util.Arrays.asList(MaritalStatus.values());
    }
}
