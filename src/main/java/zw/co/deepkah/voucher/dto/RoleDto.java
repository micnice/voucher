package zw.co.deepkah.voucher.dto;

import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
public class RoleDto {
    private String name;
    private String description;
    private Set<String> permissionSet = new HashSet<>();
}
