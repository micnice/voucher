package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.ServiceProvider;
import zw.co.deepkah.voucher.service.ServiceProviderService;

import java.util.List;

@Component
@AllArgsConstructor
public class ServiceProviderQueryResolver implements GraphQLQueryResolver {
    
    private ServiceProviderService serviceProviderService;

    public ServiceProvider serviceProviderByName(String serviceProviderName){

        return serviceProviderService.findByName(serviceProviderName);

    }

    public List<ServiceProvider> serviceProviderList(){

        return serviceProviderService.findAll().get();
    }
}
