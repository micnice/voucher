package zw.co.deepkah.voucher.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import zw.co.deepkah.voucher.document.security.User;
import zw.co.deepkah.voucher.exception.CustomException;
import zw.co.deepkah.voucher.repository.UserRepository;
import zw.co.deepkah.voucher.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public Optional<List<User>> findAll() {
        return Optional.ofNullable(userRepository.findAll());
    }

    @Override
    public Optional<User> getOne(String Id) {
        return Optional.ofNullable(userRepository.findById(Id).get());
    }



    @Override
    public void removeById(String Id) {
         userRepository.deleteById(Id);
    }

    @Override
    public void remove(User user) {
        userRepository.delete(user);
    }

    @Override
    public User save(User user) {
        if(!existsByUsername(user.getUsername())){
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
           return userRepository.save(user);
        }else
            throw new CustomException("Username is already in use", HttpStatus.UNPROCESSABLE_ENTITY);
        }



    @Override
    public UserDetails loadUserByUsername(String usernameOrEmail) throws UsernameNotFoundException {
        final User user = userRepository.findByEmailOrUsername(usernameOrEmail,usernameOrEmail);

        if (user == null) {
            throw new UsernameNotFoundException("User '" + usernameOrEmail + "' not found");
        }

        return org.springframework.security.core.userdetails.User//
                .withUsername(usernameOrEmail)//
                .password(user.getPassword())//
                .authorities(user.getRolesSet())//
                .accountExpired(false)//
                .accountLocked(false)//
                .credentialsExpired(false)//
                .disabled(false)//
                .build();
    }

    @Override
    public boolean existsByEmailOrUsername(String email, String username) {
        return userRepository.existsByEmailOrUsername(email,username);
    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User findByEmailOrUsername(String email, String username) {
        return userRepository.findByEmailOrUsername(email,username);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }
}
