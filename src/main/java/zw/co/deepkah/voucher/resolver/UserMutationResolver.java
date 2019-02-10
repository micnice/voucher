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

    public User createUser(UserDto userDto){
        User user = new User();

        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setPassword(userDto.getPassword());
        user.setEmail(userDto.getEmail());
        user.setRoleSet(userDto.getRoleSet());
        user.setUsername(userDto.getUsername());
        return userService.save(user);
       }

    public User updateUser(UserDto userDto, Optional<String> userId){
        User user = new User();
        if(userId.isPresent()){
            user = userService.getOne(userId.get()).get();
            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setPassword(userDto.getPassword());
            user.setEmail(userDto.getEmail());
            user.setRoleSet(userDto.getRoleSet());
            user.setUsername(userDto.getUsername());
        }

        return userService.save(user);
    }
}
