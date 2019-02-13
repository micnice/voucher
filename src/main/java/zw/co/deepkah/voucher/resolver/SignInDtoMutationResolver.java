package zw.co.deepkah.voucher.resolver;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import zw.co.deepkah.voucher.configuration.security.jwt.JwtProvider;
import zw.co.deepkah.voucher.document.security.Role;
import zw.co.deepkah.voucher.dto.SignInDto;
import zw.co.deepkah.voucher.message.response.UserDtoResponse;
import zw.co.deepkah.voucher.repository.RoleRepository;
import zw.co.deepkah.voucher.repository.UserRepository;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@AllArgsConstructor
public class SignInDtoMutationResolver implements GraphQLMutationResolver {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserRepository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    PasswordEncoder encoder;

    @Autowired
    JwtProvider jwtProvider;


   public SignInDto signin(String username, String password){
       SignInDto userDtoResponse = new SignInDto();
       Authentication authentication=null;
       String jwt = null;
       try{
           authentication = authenticationManager.authenticate(
               new UsernamePasswordAuthenticationToken(
                       username,
                       password
               )
       );
       if(authentication!=null) {
           SecurityContextHolder.getContext().setAuthentication(authentication);
       }

       try {
           jwt = jwtProvider.generateJwtToken(authentication);
       }catch (Exception ex){

       } }
       catch (Exception e){

       }  finally{
           userDtoResponse.setToken(jwt);
           userDtoResponse.setUsername(username);
           Set<Role> roles = new HashSet<>();
           if(authentication!=null){
               authentication.getAuthorities().forEach(a->{
                   roles.add(roleRepository.findByName(a.getAuthority()));

               });
           }
           userDtoResponse.setRoleSet((roles));
       }


       return userDtoResponse;
   }
}
