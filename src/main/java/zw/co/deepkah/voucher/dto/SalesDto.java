package zw.co.deepkah.voucher.dto;

import lombok.Data;




@Data
public class SalesDto {

    private String beneficiaryIdentityId;
    private String voucherSerialNumber;
    private String saleDate;
    private String soldBy;
    private String voucherSet;
}
