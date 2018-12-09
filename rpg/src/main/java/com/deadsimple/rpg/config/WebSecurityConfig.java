package com.deadsimple.rpg.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.security.authentication.encoding.PlaintextPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    // TODO use real encryption
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new PlaintextPasswordEncoder();
    }

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    AuthenticationFailureHandler afh;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/public").permitAll()
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                // TODO switch to formLogin, call failureHandler off of formLogin() to register
                // LoginFailureHandler, which lets us control account lockouts.
                //.formLogin()
                //.permitAll()
                .and()
                .logout()
                .permitAll();
    }

    @Bean
    AuthenticationFailureHandler afh() {
        return new LoginFailureHandler();
    }
}
