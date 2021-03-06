package zw.co.deepkah.voucher.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import zw.co.deepkah.voucher.document.BaseId;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class BaseName extends BaseId {

    private String name;
    private String description;
}
