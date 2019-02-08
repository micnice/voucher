package zw.co.deepkah.voucher.resources;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import zw.co.deepkah.voucher.configuration.security.JwtAuthenticationProvider;
import zw.co.deepkah.voucher.document.security.User;
import zw.co.deepkah.voucher.payload.ApiResponse;
import zw.co.deepkah.voucher.payload.JwtAuthenticationResponse;
import zw.co.deepkah.voucher.payload.LoginRequest;
import zw.co.deepkah.voucher.payload.SignUpRequest;
import zw.co.deepkah.voucher.repository.RoleRepository;
import zw.co.deepkah.voucher.service.UserService;
import javax.validation.Valid;



@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    AuthenticationManager authenticationManager;

    UserService  userService;
    RoleRepository roleRepository;
    JwtAuthenticationProvider tokenProvider;

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                 loginRequest.getUsernameOrEmail(),loginRequest.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {
        if(userService.existsByEmailOrUsername(signUpRequest.getUsername(),signUpRequest.getEmail())) {
            return new ResponseEntity(new ApiResponse(false, "Username or Email is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        // Creating user's account
        User user = new User(signUpRequest.getUsername(),signUpRequest.getPassword(),signUpRequest.getFirstName(),signUpRequest.getLastName(),
                signUpRequest.getEmail(), signUpRequest.getRolesSet());
        User result = userService.save(user);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Success registration", String.valueOf(new ApiResponse(true, "User registered successfully")));


        return new ResponseEntity(result,httpHeaders,HttpStatus.OK);
    }
}
