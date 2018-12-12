package zw.co.deepkah.voucher.document;

import lombok.Data;
import zw.co.deepkah.voucher.document.BaseId;

@Data
public abstract class BaseName extends BaseId {

    private String name;
    private String description;
}
