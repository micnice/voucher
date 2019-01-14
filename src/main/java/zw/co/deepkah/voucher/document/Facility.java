package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "facility")
@NoArgsConstructor
public class Facility  extends BaseId{

    private String name;
    private String description;

    public Facility(String id) {
        super(id);
    }
}
