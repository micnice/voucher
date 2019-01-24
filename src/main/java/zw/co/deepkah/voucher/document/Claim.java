package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "claim")
@NoArgsConstructor
public class Claim extends BaseId {
            private ServiceProvider serviceProvider;
            private BeneficiaryIdentification beneficiaryIdentification;
            private VoucherType voucherType;
            private Sales sales;
            private Boolean redeemed = Boolean.FALSE;
            private LocalDate redemptionDate;

    public Claim(String id) {
        super(id);
    }
}
