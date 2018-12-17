package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.ServiceProvisionLevel;
import zw.co.deepkah.voucher.document.VoucherPriceScale;
import zw.co.deepkah.voucher.document.VoucherType;
import zw.co.deepkah.voucher.repository.VoucherPriceScaleRepository;
import zw.co.deepkah.voucher.repository.VoucherTypeRepository;
import zw.co.deepkah.voucher.service.VoucherPriceScaleService;
import zw.co.deepkah.voucher.service.VoucherTypeService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class VoucherPriceScaleServiceImp implements VoucherPriceScaleService {

    private VoucherPriceScaleRepository voucherPriceScaleRepository;
    @Override
    public Optional<List<VoucherPriceScale>> findAll() {
        return Optional.ofNullable(voucherPriceScaleRepository.findAll());
    }

    @Override
    public Optional<VoucherPriceScale> getOne(String Id) {
        return Optional.ofNullable(voucherPriceScaleRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
        voucherPriceScaleRepository.deleteById(Id);
    }

    @Override
    public void remove(VoucherPriceScale voucherPriceScale) {
        voucherPriceScaleRepository.delete(voucherPriceScale);
    }

    @Override
    public VoucherPriceScale save(VoucherPriceScale voucherPriceScale) {
        return voucherPriceScaleRepository.save(voucherPriceScale);
    }

    @Override
    public List<VoucherPriceScale> findByVoucherType(VoucherType voucherType) {
        return voucherPriceScaleRepository.findByVoucherType(voucherType);
    }

    @Override
    public List<VoucherPriceScale> findByPriceOfService(Double aDouble) {
        return voucherPriceScaleRepository.findByPriceOfService(aDouble);
    }

    @Override
    public List<VoucherPriceScale> findByServiceProvisionLevel(ServiceProvisionLevel serviceProvisionLevel) {
        return voucherPriceScaleRepository.findByServiceProvisionLevel(serviceProvisionLevel);
    }
}
