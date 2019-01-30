package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.Permission;
import zw.co.deepkah.voucher.service.PermissionService;

import java.util.List;

@Component
@AllArgsConstructor
public class PermissionQueryResolver implements GraphQLQueryResolver {

    private PermissionService permissionService;


    public List<Permission> permissionList(){
        return permissionService.findAll().get();
    }


}
