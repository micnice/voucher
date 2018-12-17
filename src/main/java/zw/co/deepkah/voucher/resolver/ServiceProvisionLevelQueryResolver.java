package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.ServiceProvisionLevel;

import java.util.Arrays;
import java.util.List;

@Component
public class ServiceProvisionLevelQueryResolver  implements GraphQLQueryResolver {


    public List<ServiceProvisionLevel> serviceProvisionLevelList(){
        return Arrays.asList(ServiceProvisionLevel.values());
    }
}
