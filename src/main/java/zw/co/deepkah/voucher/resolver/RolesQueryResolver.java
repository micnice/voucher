package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.Roles;

import java.util.Arrays;
import java.util.List;

@Component
public class RolesQueryResolver implements GraphQLQueryResolver {


    public List<Roles> rolesList(){
        return Arrays.asList(Roles.values());
    }
}
