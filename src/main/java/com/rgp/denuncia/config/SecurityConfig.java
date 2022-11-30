package com.rgp.denuncia.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {
    private final String[] allowed = {
            "/v3/api-docs/**",
            "/v3/api-docs.yaml",
            "/swagger-ui/**",
            "/webjars/**"
    };

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf()
                .disable()
                .cors()
                .disable()
                .authorizeHttpRequests()
                .antMatchers(allowed)
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .oauth2ResourceServer()
                .jwt();
        return http.build();
    }
}
