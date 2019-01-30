package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.Permission;
import zw.co.deepkah.voucher.document.security.Role;
import zw.co.deepkah.voucher.dto.RoleDto;
import zw.co.deepkah.voucher.service.PermissionService;
import zw.co.deepkah.voucher.service.RoleService;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
@AllArgsConstructor
public class RoleMutationResolver implements GraphQLMutationResolver {
    private RoleService roleService;
    private PermissionService permissionService;


    public Role createRole(RoleDto roleDto){
        Role role = new Role();
        Set<Permission> permissionSet = new HashSet<>();
        roleDto.getPermissionSet().stream().forEach(s -> {
            permissionSet.add(permissionService.findOne(s));
        });
        role.setPermissionSet(permissionSet);
        role.setName(roleDto.getName());
        role.setDescription(roleDto.getDescription());
        return roleService.save(role);
    }

    public Role updateRole(RoleDto roleDto, Optional<String> roleId){
        Role role = new Role();
        roleId.ifPresent(s -> {
            Set<Permission> permissionSet = new HashSet<>();
            roleDto.getPermissionSet().stream().forEach(r -> {
                permissionSet.add(permissionService.findOne(r));
            });
            role.equals(roleService.findOne(s));
            role.setName(roleDto.getName());
            role.setDescription(roleDto.getDescription());
        });
        return roleService.save(role);
    }
}
