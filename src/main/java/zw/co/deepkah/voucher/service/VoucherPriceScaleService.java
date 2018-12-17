package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.ServiceProvisionLevel;
import zw.co.deepkah.voucher.document.VoucherPriceScale;
import zw.co.deepkah.voucher.document.VoucherType;

import java.util.List;

public interface VoucherPriceScaleService extends IService<VoucherPriceScale> {

    List<VoucherPriceScale> findByVoucherType(VoucherType voucherType);
    List<VoucherPriceScale> findByPriceOfService(Double aDouble);
    List<VoucherPriceScale> findByServiceProvisionLevel(ServiceProvisionLevel serviceProvisionLevel);
}
