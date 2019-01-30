package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.Permission;
import zw.co.deepkah.voucher.dto.PermissionDto;
import zw.co.deepkah.voucher.service.PermissionService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class PermissionMutationResolver implements GraphQLMutationResolver {

    private PermissionService permissionService;

    public Permission createPermission(PermissionDto permissionDto){
        Permission permission = new Permission();
        permission.setName(permissionDto.getName());
        return permissionService.save(permission);
    }

    public Permission updatePermission(PermissionDto permissionDto, Optional<String> permissionId){
        Permission permission = new Permission();
        permissionId.ifPresent(s -> {
          permission.equals(permissionService.findOne(s));
          permission.setName(permissionDto.getName());
        });
        return permissionService.save(permission);
    }

}


