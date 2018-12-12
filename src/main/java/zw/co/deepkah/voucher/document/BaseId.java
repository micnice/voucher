package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Data
public abstract class BaseId {
    @Id
    private String Id;
    private String createdBy;//Identified by
    private LocalDate dateCreated;//Date identified
    private String modifiedBy;
    private LocalDate dateModified;
}
