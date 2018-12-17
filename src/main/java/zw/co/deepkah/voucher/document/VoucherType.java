package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@NoArgsConstructor
public class VoucherType extends BaseId {

    private String name;
    private String description;

    public VoucherType(String id) {
        super(id);
    }
}
