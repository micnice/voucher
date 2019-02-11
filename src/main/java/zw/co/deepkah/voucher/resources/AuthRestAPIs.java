package zw.co.deepkah.voucher.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import zw.co.deepkah.voucher.configuration.security.jwt.JwtProvider;
import zw.co.deepkah.voucher.document.security.Role;
import zw.co.deepkah.voucher.document.security.User;
import zw.co.deepkah.voucher.dto.UserResponseDTO;
import zw.co.deepkah.voucher.message.request.LoginForm;
import zw.co.deepkah.voucher.message.request.SignUpForm;
import zw.co.deepkah.voucher.message.response.JwtResponse;
import zw.co.deepkah.voucher.repository.RoleRepository;
import zw.co.deepkah.voucher.repository.UserRepository;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

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

    @PostMapping("/signin")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(),
                        loginRequest.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateJwtToken(authentication);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }

    @PostMapping("/signup")
    public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
        if(userRepository.existsByUsername(signUpRequest.getUsername())) {
            return new ResponseEntity<String>("Fail -> Username is already taken!",
                    HttpStatus.BAD_REQUEST);
        }

        if(userRepository.existsByEmail(signUpRequest.getEmail())) {
            return new ResponseEntity<String>("Fail -> Email is already in use!",
                    HttpStatus.BAD_REQUEST);
        }
        Set<Role> roles = new HashSet<>();
        // Creating user's account
        User user = new User(signUpRequest.getFirstName(),signUpRequest.getLastName(), signUpRequest.getUsername(),
                signUpRequest.getEmail(), encoder.encode(signUpRequest.getPassword()));
                signUpRequest.getRole().stream().forEach(s -> roles.add(roleRepository.findByName(s.getName())));
                user.setRoleSet(roles);
        userRepository.save(user);

        return ResponseEntity.ok().body("User registered successfully!");
    }
}