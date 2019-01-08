package zw.co.deepkah.voucher.document;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Set;

@Document(collection = "voucher_set")
@Data
public class VoucherSet extends BaseId {

   private String name;
   private String description;
   private Set<VoucherType> voucherTypeSet;


}
