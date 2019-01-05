package zw.co.deepkah.voucher.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.Sales;
import zw.co.deepkah.voucher.repository.SalesRepository;
import zw.co.deepkah.voucher.service.SalesService;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class SalesServiceImpl implements SalesService {

    private SalesRepository salesRepository;

    @Override
    public Optional<List<Sales>> findAll() {
        return Optional.ofNullable(salesRepository.findAll());
    }

    @Override
    public Optional<Sales> getOne(String Id) {
        return Optional.ofNullable(salesRepository.findById(Id).get());
    }

    @Override
    public void removeById(String Id) {
         salesRepository.deleteById(Id);
    }

    @Override
    public void remove(Sales sales) {
 salesRepository.delete(sales);
    }

    @Override
    public Sales save(Sales sales) {
        return salesRepository.save(sales);
    }

    @Override
    public Sales findByVoucherSerialNumber(String voucherSerialNumber) {
        return salesRepository.findByVoucherSerialNumber(voucherSerialNumber);
    }
}
