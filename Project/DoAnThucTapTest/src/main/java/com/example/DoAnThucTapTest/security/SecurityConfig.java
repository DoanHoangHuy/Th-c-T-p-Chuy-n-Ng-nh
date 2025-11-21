package com.example.DoAnThucTapTest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
@Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails huy = User.builder().username("huy")
                                    .password("{noop}123")
                                    .roles("EMPLOYEE")
                                    .build();
        return new InMemoryUserDetailsManager(huy);
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->configurer
                        .requestMatchers("/css/**", "/js/**", "/vendor/**").permitAll()
                                .anyRequest()
                                .authenticated())
                        .formLogin(form->form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser").permitAll())
                        .logout(logout->logout
                                .permitAll());
        return http.build();
    }
}
