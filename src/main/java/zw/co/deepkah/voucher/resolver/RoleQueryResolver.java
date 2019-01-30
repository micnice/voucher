package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.Role;
import zw.co.deepkah.voucher.service.RoleService;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class RoleQueryResolver implements GraphQLQueryResolver {
    private RoleService roleService;


    public List<Role> roleList(){
        return roleService.findAll().get();
        }

        public Role roleByName(String name){
         return    roleService.findByName(name);
        }
}
