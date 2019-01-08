package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.VoucherSet;
import zw.co.deepkah.voucher.repository.VoucherSetRepository;
import zw.co.deepkah.voucher.service.VoucherSetService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoucherSetServiceImpl implements VoucherSetService {

    private VoucherSetRepository voucherSetRepository;


    @Override
    public VoucherSet findByName(String name) {
        return voucherSetRepository.findByName(name);
    }

    @Override
    public Optional<List<VoucherSet>> findAll() {
        return Optional.ofNullable(voucherSetRepository.findAll());
    }

    @Override
    public Optional<VoucherSet> getOne(String Id) {
        return Optional.ofNullable(voucherSetRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
        voucherSetRepository.deleteById(Id);
    }

    @Override
    public void remove(VoucherSet voucherSet) {
        voucherSetRepository.delete(voucherSet);
    }

    @Override
    public VoucherSet save(VoucherSet voucherSet) {
        return voucherSetRepository.save(voucherSet);
    }
}
