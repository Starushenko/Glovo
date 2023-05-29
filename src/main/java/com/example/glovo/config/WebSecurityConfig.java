package com.example.glovo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.formLogin(formLogin ->
                formLogin
                        .loginPage("/login")
                        .permitAll())
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .requestMatchers("/orders/{id}").permitAll()
                                .anyRequest().authenticated())
                .logout(logout -> logout.permitAll());
        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService(){
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        UserDetails user =
                User
                        .withUsername("user")
                        .password("{bcrypt}$2a$10$9FZTi0VwAxiZY3d5SYZMO.j4Zu96iTvEOETT.pn9JloEbLLNBz39G")
                        .roles("USER")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }


}
