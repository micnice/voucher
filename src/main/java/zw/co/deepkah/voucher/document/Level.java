package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "level")
public class Level extends BaseId{
    private String name;
    private String description;
}
