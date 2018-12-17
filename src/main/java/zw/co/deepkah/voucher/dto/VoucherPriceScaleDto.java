package zw.co.deepkah.voucher.dto;

import lombok.Data;
import zw.co.deepkah.voucher.document.ServiceProvisionLevel;
import zw.co.deepkah.voucher.document.VoucherType;

import java.math.BigDecimal;

@Data
public class VoucherPriceScaleDto {
    private String id;
    private VoucherType voucherType;
    private ServiceProvisionLevel serviceProvisionLevel;
    private BigDecimal priceOfService;
}
