package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.ContactDetails;
import zw.co.deepkah.voucher.repository.ContactDetailsRepository;
import zw.co.deepkah.voucher.service.ContactDetailsService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ContactDetailsServiceImpl implements ContactDetailsService {

    private ContactDetailsRepository contactDetailsRepository;
    @Override
    public Optional<List<ContactDetails>> findAll() {
        return Optional.ofNullable(contactDetailsRepository.findAll());
    }

    @Override
    public Optional<ContactDetails> getOne(String Id) {
        return Optional.ofNullable(contactDetailsRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
            contactDetailsRepository.deleteById(Id);
    }

    @Override
    public void remove(ContactDetails contactDetails) {
         contactDetailsRepository.delete(contactDetails);
    }

    @Override
    public ContactDetails save(ContactDetails contactDetails) {
        return contactDetailsRepository.save(contactDetails);
    }
}
