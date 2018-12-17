package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.VoucherType;
import zw.co.deepkah.voucher.repository.VoucherTypeRepository;
import zw.co.deepkah.voucher.service.VoucherTypeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoucherTypeServiceImpl implements VoucherTypeService {

    private VoucherTypeRepository voucherTypeRepository;
    @Override
    public Optional<List<VoucherType>> findAll() {
        return Optional.ofNullable(voucherTypeRepository.findAll());
    }

    @Override
    public Optional<VoucherType> getOne(String Id) {
        return Optional.ofNullable(voucherTypeRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
            voucherTypeRepository.deleteById(Id);
    }

    @Override
    public void remove(VoucherType voucherType) {
            voucherTypeRepository.delete(voucherType);
    }

    @Override
    public VoucherType save(VoucherType voucherType) {
        return voucherTypeRepository.save(voucherType);
    }



    @Override
    public VoucherType findByName(String name) {
        return voucherTypeRepository.findByName(name);
    }
}
