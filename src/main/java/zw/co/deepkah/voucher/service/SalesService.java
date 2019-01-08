package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.Sales;

import java.util.List;

public interface SalesService extends IService<Sales> {

    Sales findByVoucherSerialNumber(String voucherSerialNumber);
    List< Sales> findAllByBeneficiaryIdentityId(String beneficiaryIdentityId);
}
