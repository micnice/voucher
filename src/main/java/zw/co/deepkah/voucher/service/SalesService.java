package zw.co.deepkah.voucher.service;

import zw.co.deepkah.voucher.document.Sales;

public interface SalesService extends IService<Sales> {

    Sales findByVoucherSerialNumber(String voucherSerialNumber);
}
