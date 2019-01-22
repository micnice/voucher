package zw.co.deepkah.voucher.document;

import lombok.Data;

@Data
public class SaleIdentificationData {

    private String beneficiaryIdentityId;
    private String saleId;
    private String identificationNumber;
    private String firstName;
    private String lastName;
    private String voucherSerialNumber;
    private String packageName;
}
