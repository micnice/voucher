package zw.co.deepkah.voucher.document.security;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import zw.co.deepkah.voucher.document.BaseId;

import java.util.HashSet;
import java.util.Set;

@Data
@Document(collection = "role")
public class Role extends BaseId {
    private String name;
    private String description;
    private Set<Permission> permissionSet = new HashSet<>();
}
