package zw.co.deepkah.voucher.dto;

import lombok.Data;


import java.util.Set;

@Data
public class VoucherSetDto {

    private String name;
    private String description;
    private Set<String> voucherTypeSet;
}
