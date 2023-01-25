package com.steven.webappdemo1.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.function.Function;

@Configuration
public class SpringSecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager createUserDetail() {

        UserDetails userDetails1 = createNewUser("steven", "haruka");
        UserDetails userDetails2 = createNewUser("chloe", "harukaharuka");

        return new InMemoryUserDetailsManager(userDetails1, userDetails2);
    }

    private UserDetails createNewUser(String username, String password) {
        Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

        UserDetails userDetails = User.builder()
                .passwordEncoder(passwordEncoder)
                .username(username)
                .password(password)
                .roles("USER", "ADMIN")
                .build();
        return userDetails;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //Reconfiguration the spring boot security for using H2
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        //All urls are need to be authorized
        httpSecurity.authorizeHttpRequests(authorization -> authorization.anyRequest().authenticated());
        //Show login form to all unauthorized pages
        httpSecurity.formLogin(Customizer.withDefaults());

        //Disable CSRF
        httpSecurity.csrf().disable();
        //Enable use of frames
        httpSecurity.headers().frameOptions().disable();

        return httpSecurity.build();
    }
}
