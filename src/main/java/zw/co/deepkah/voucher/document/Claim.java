package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "claim")
@NoArgsConstructor
public class Claim extends BaseId {
            private ServiceProvider serviceProvider;
            private BeneficiaryIdentification beneficiaryIdentification;
            private VoucherType voucherType;
            private Sales sales;

    public Claim(String id) {
        super(id);
    }
}
