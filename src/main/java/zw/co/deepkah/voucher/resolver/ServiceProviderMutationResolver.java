package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.City;
import zw.co.deepkah.voucher.document.ServiceProvider;
import zw.co.deepkah.voucher.dto.ServiceProviderDto;
import zw.co.deepkah.voucher.service.CityService;
import zw.co.deepkah.voucher.service.ServiceProviderService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class ServiceProviderMutationResolver implements GraphQLMutationResolver {
    
    private ServiceProviderService serviceProviderService;
    private CityService cityService;


    public ServiceProvider createServiceProvider(ServiceProviderDto serviceProviderDto){
        System.out.println("------------------"+serviceProviderDto.getCityId());
        ServiceProvider serviceProvider= new ServiceProvider();
        serviceProvider.setName(serviceProviderDto.getName());
        serviceProvider.setDescription(serviceProviderDto.getDescription());
//        serviceProvider.setCity(new City(serviceProviderDto.getCityId()));
        serviceProvider.setCity(cityService.getOne(serviceProviderDto.getCityId()).get());

        System.out.println("pppppppppppppppp===="+serviceProvider.getCity().getId());
        return serviceProviderService.save(serviceProvider);
    }

    public ServiceProvider updateServiceProvider(ServiceProviderDto serviceProviderDto, Optional<String> serviceProviderId){
        ServiceProvider serviceProvider = new ServiceProvider();
        City city = new City();

        serviceProvider.setCity(cityService.getOne(serviceProviderDto.getCityId()).get());
        serviceProviderId.ifPresent(s -> {

            serviceProvider.setId(serviceProviderService.getOne(s).get().getId());
            serviceProvider.setName(serviceProviderDto.getName());
            serviceProvider.setDescription(serviceProviderDto.getDescription());
            serviceProvider.setCity(cityService.getOne(serviceProviderDto.getCityId()).get());



            });

        return serviceProvider;
    }
    
}
