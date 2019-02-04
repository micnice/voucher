package zw.co.deepkah.voucher.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
public class OneTimePassword {
            private String oTP;
            private String saleId;
}
