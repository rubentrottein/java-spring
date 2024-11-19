package com.payme.app.security;

import com.payme.app.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().requestMatchers(
                "/css/**", "/js/**", "/images/**"
        );
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/", "/register", "/login").permitAll();
                auth.anyRequest().authenticated();
            })
            .formLogin(form -> form
                    .loginPage("/login")
                    .permitAll()
                    .successHandler((request, response, authentication) -> {
                        System.out.println("Authentication successful. Redirecting to /profile...");
                        response.sendRedirect("/profile");
                    })
            )
            .logout(logout -> logout
                    .logoutUrl("/logout") // URL pour déclencher le logout
                    //.logoutSuccessUrl("/login?logout") // Redirection après la déconnexion
                    .logoutSuccessUrl("/confirmation") // Redirection après la déconnexion
                    .invalidateHttpSession(true) // Invalide la session
                    .deleteCookies("JSESSIONID") // Supprime le cookie de session
                    .permitAll()
            )
        .userDetailsService(customUserDetailsService)
        .build();
    }
}