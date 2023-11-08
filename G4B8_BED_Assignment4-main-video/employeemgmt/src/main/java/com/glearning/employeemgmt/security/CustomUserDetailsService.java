package com.glearning.employeemgmt.security;

import com.glearning.employeemgmt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import com.glearning.employeemgmt.entity.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements  UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optionalUser = userRepository.findByUsername(username);
        if(optionalUser.isPresent())

        {
            User user = optionalUser.get();
            org.springframework.security.core.userdetails.User authUser = new org.springframework.security.core.userdetails.User(
                 user.getUsername(),
                    user.getPassword(),
                    user.getRoles().stream().map((role -> new SimpleGrantedAuthority(role.getName()))).collect(Collectors.toList()));

            return authUser;
        }
        else {
            throw new UsernameNotFoundException("Invalid user name and password");
        }

    }
}
