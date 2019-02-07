package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.document.security.User;
import zw.co.deepkah.voucher.dto.UserDto;
import zw.co.deepkah.voucher.service.UserService;

import java.util.Optional;

@Component
@AllArgsConstructor
public class UserMutationResolver implements GraphQLMutationResolver {

    private UserService userService;

    public User createUser(User user){


       userService.saveUser(user);
       return user;


       }

    public User updateUser(User user, Optional<String> userId){
//        User user = new User();
        if(userId.isPresent()){
            user = userService.getOne(userId.get()).get();

        }

        return userService.save(user);
    }
}
