package zw.co.deepkah.voucher.document.security;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import zw.co.deepkah.voucher.document.BaseId;

@Data
@Document(collection = "permission")
public class Permission extends BaseId {
    private String name;
}
