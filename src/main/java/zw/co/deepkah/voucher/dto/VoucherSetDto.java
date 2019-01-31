package zw.co.deepkah.voucher.dto;

import lombok.Data;


import java.util.List;
import java.util.Set;

@Data
public class VoucherSetDto {

    private String name;
    private String description;
    private List<String> voucherTypeSet;
}
