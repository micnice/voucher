package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.City;
import zw.co.deepkah.voucher.repository.CityRepository;
import zw.co.deepkah.voucher.service.CityService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CityServiceImpl implements CityService {

    private CityRepository cityRepository;

    @Override
    public Optional<List<City>> findAll() {
        return Optional.ofNullable(cityRepository.findAll());
    }

    @Override
    public City findByName(String name) {
        return cityRepository.findByName(name);
    }

    @Override
    public Optional<City> getOne(String Id) {
        return Optional.ofNullable(cityRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
         cityRepository.deleteById(Id);
    }

    @Override
    public void remove(City city) {
           cityRepository.delete(city);
    }

    @Override
    public City save(City city) {
        return cityRepository.save(city);
    }
}
