package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.ServiceProvider;
import zw.co.deepkah.voucher.repository.ServiceProviderRepository;
import zw.co.deepkah.voucher.service.ServiceProviderService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Service
public class ServiceProviderServiceImp implements ServiceProviderService {

    private ServiceProviderRepository serviceProviderRepository;
    @Override
    public Optional<List<ServiceProvider>> findAll() {
        return Optional.ofNullable(serviceProviderRepository.findAll());
    }

    @Override
    public Optional<ServiceProvider> getOne(String Id) {
        return Optional.ofNullable(serviceProviderRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
        serviceProviderRepository.deleteById(Id);
    }

    @Override
    public void remove(ServiceProvider serviceProvider) {
   serviceProviderRepository.delete(serviceProvider);
    }

    @Override
    public ServiceProvider save(ServiceProvider serviceProvider) {
        return serviceProviderRepository.save(serviceProvider);
    }


}
