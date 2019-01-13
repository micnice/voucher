package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.ServiceProvider;
import zw.co.deepkah.voucher.document.VoucherSet;




@Data
public class SalesDto {

    private String beneficiaryIdentityId;
    private String voucherSerialNumber;
    private String saleDate;
    private String soldBy;
    private String voucherSetId;
}
