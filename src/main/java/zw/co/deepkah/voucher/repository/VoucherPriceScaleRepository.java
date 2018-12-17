package zw.co.deepkah.voucher.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import zw.co.deepkah.voucher.document.ServiceProvisionLevel;
import zw.co.deepkah.voucher.document.VoucherPriceScale;
import zw.co.deepkah.voucher.document.VoucherType;

import java.util.List;

public interface

VoucherPriceScaleRepository extends MongoRepository<VoucherPriceScale,String> {

    List<VoucherPriceScale> findByVoucherType(VoucherType voucherType);
    List<VoucherPriceScale> findByPriceOfService(Double aDouble);
    List<VoucherPriceScale> findByServiceProvisionLevel(ServiceProvisionLevel serviceProvisionLevel);
}
