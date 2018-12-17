package zw.co.deepkah.voucher.document;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public abstract class BaseId {
    @Id
    private String id;
    private String createdBy;//Identified by
    private LocalDate dateCreated;//Date identified
    private String modifiedBy;
    private LocalDate dateModified;


    public BaseId(String id) {
        this.id = id;
    }
}
