package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document
@Data
public class VoucherPriceScale extends BaseId {

    private VoucherType voucherType;
    private ServiceProvisionLevel serviceProvisionLevel;
    private BigDecimal priceOfService;
}
