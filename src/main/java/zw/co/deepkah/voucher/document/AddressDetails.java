package zw.co.deepkah.voucher.document;

import lombok.Data;

@Data
public class AddressDetails extends BaseId {

    private String beneficiaryIdentificationId;
    private AddressType addressType;
    private String addressDescription;

}
