package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.Facility;
import zw.co.deepkah.voucher.repository.FacilityRepository;
import zw.co.deepkah.voucher.service.FacilityService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FacilityServiceImpl implements FacilityService {

    private FacilityRepository facilityRepository;
    @Override
    public Optional<List<Facility>> findAll() {
        return Optional.ofNullable(facilityRepository.findAll());
    }

    @Override
    public Optional<Facility> getOne(String Id) {
        return Optional.ofNullable(facilityRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
        facilityRepository.deleteById(Id);
    }

    @Override
    public void remove(Facility facility) {
       facilityRepository.delete(facility);
    }

    @Override
    public Facility save(Facility facility) {
        return facilityRepository.save(facility);
    }

    @Override
    public Facility findByName(String name) {
        return facilityRepository.findByName(name);
    }
}
