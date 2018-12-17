package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@Data
@Document
public class City extends BaseId {

    private String name;
    private String description;

    public City(String id) {
        super(id);
    }
}
