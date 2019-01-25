package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.ServiceProvider;
import zw.co.deepkah.voucher.repository.ServiceProviderRepository;
import zw.co.deepkah.voucher.service.ServiceProviderService;

import java.util.List;

@Component
@AllArgsConstructor
public class ServiceProviderQueryResolver implements GraphQLQueryResolver {
    
    private ServiceProviderService serviceProviderService;
    private ServiceProviderRepository serviceProviderRepository;

    public ServiceProvider serviceProviderByName(String serviceProviderName){

        return serviceProviderService.findByName(serviceProviderName);

    }

    public List<ServiceProvider> serviceProviderList(){

        return serviceProviderService.findAll().get();
    }

    public List<ServiceProvider> serviceProviderByCity(String cityId){
       return  serviceProviderRepository.findByCityId(cityId);
    }
}
