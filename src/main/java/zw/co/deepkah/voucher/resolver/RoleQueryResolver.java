package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.Role;

import java.util.Arrays;
import java.util.List;

@Component
@AllArgsConstructor
public class RoleQueryResolver implements GraphQLQueryResolver {


    public List<Role> roleList(){
        return Arrays.asList(Role.values());
    }
}
