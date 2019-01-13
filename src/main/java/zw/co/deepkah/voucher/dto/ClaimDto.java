package zw.co.deepkah.voucher.dto;

import lombok.Data;

@Data
public class ClaimDto {

    private String facilityId;
    private String beneficiaryId;
    private String voucherTypeId;
    private String salesId;
}
