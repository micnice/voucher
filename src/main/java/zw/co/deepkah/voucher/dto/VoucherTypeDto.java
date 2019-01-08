package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.Level;

import java.math.BigDecimal;

@Data
public class VoucherTypeDto {

    private String name;
    private String description;
    private String levelId;
    private BigDecimal price;
}
