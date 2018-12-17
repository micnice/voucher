package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.AddressDetails;
import zw.co.deepkah.voucher.repository.AddressDetailsRepository;
import zw.co.deepkah.voucher.service.AddressDetailsService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AddressServiceImpl implements AddressDetailsService {

    private AddressDetailsRepository addressDetailsRepository;


    @Override
    public Optional<List<AddressDetails>> findAll() {
        return Optional.ofNullable(addressDetailsRepository.findAll());
    }

    @Override
    public Optional<AddressDetails> getOne(String Id) {
        return Optional.ofNullable(addressDetailsRepository.findById(Id).get());
    }

//    @Override
//    public Optional<String> getOne(String Id) {
//        return Optional.ofNullable(addressDetailsRepository.findById(Id));
//    }

    @Override
    public void removeById(String Id) {
          addressDetailsRepository.deleteById(Id);
    }

    @Override
    public void remove(AddressDetails addressDetails) {
      addressDetailsRepository.delete(addressDetails);
    }

    @Override
    public AddressDetails save(AddressDetails addressDetails) {
        return addressDetailsRepository.save(addressDetails);
    }
}
