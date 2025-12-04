package com.example.DoAnThucTapTest.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
    }
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer->configurer
                                .requestMatchers("/css/**", "/js/**", "/vendor/**" ,"/images/**").permitAll()
                                .requestMatchers("/admin/**").hasRole("MANAGER")
                        .requestMatchers("/user/**").hasAnyRole("USER","ADMIN")
                                .anyRequest().permitAll())
                                .formLogin(form->form
                                .loginPage("/login")
                                .loginProcessingUrl("/authenticateTheUser").permitAll())
                                .logout(logout->logout.permitAll());
        return http.build();
    }
}
