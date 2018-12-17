package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.City;
import zw.co.deepkah.voucher.repository.CityRepository;
import zw.co.deepkah.voucher.service.CityService;

import java.util.List;

@Component
@AllArgsConstructor
public class CityQueryResolver implements GraphQLQueryResolver {
    private CityService cityService;

    public City cityByName(String cityName){

     return cityService.findByName(cityName);

     }

     public List<City> cityList(){
        return cityService.findAll().get();
     }
}
