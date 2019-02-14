package zw.co.deepkah.voucher.dto;

import lombok.Data;



@Data
public class ClaimDto {


    private String serviceProvider;
    private String beneficiaryIdentification;
    private String voucherType;
    private String sales;
    private String processedBy;
}
