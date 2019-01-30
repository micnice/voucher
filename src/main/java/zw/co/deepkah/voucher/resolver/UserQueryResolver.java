package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.User;
import zw.co.deepkah.voucher.service.UserService;

import java.util.List;

@Component
@AllArgsConstructor
public class UserQueryResolver implements GraphQLQueryResolver {
    private UserService  userService;


    public List<User> getUserList(){
        return userService.findAll().get();
    }
}
