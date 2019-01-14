package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "sales")
public class Sales extends BaseId {

    private String beneficiaryIdentityId;
    private String voucherSerialNumber;
    private LocalDate saleDate;
    private String soldBy;
    private VoucherSet voucherSet;


}
