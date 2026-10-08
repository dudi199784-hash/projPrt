
package com.practiceAiAtena.global.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class ApiSecurityConfig {

    @Bean
    @Order(1)
    SecurityFilterChain apiFilterChain(HttpSecurity http) throws Exception {
        http
                .securityMatcher("/api/**")
                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/api/*/articles").permitAll()
                        .requestMatchers("/api/*/articles/*").permitAll()
                        .anyRequest().authenticated()
                )
                .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
