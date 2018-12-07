package com.deadsimple.rpg.config;

import com.deadsimple.rpg.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

@Component
public class MongoUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return repo.findByUsername(email);
    }
}
