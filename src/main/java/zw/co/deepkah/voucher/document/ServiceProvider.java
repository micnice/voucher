package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@Document
public class ServiceProvider extends BaseId {
    private String name;
    private String description;
    private City city;

    public ServiceProvider(String id) {
        super(id);
    }
}
