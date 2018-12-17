package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.City;
import zw.co.deepkah.voucher.dto.CityDto;
import zw.co.deepkah.voucher.service.CityService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class CityMutationResolver implements GraphQLMutationResolver {

    private CityService cityService;


    public City createCity(CityDto cityDto){
        City city= new City();
        city.setName(cityDto.getName());
        city.setDescription(cityDto.getDescription());
        return cityService.save(city);
    }

    public City updateCity(CityDto cityDto, Optional<String> cityId){
        City city = new City();
        cityId.ifPresent(s -> {

            city.setId(cityService.getOne(s).get().getId());
            city.setName(cityDto.getName());
            city.setDescription(cityDto.getDescription());
        });

        return city;
    }
}
