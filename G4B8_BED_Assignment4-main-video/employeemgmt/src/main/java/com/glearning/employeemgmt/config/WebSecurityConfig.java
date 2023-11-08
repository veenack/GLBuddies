package com.glearning.employeemgmt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class WebSecurityConfig {

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    @Bean(name = "securityFilterChain")
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests((authorize)->authorize
                .requestMatchers(new AntPathRequestMatcher("/role/**")).authenticated()
                .requestMatchers(new AntPathRequestMatcher("/user/**")).authenticated()
                .requestMatchers(new AntPathRequestMatcher("/api/employees/create")).hasRole("ADMIN")
                .requestMatchers(new AntPathRequestMatcher("/api/employees/**")).authenticated()
                .requestMatchers(new AntPathRequestMatcher("/swagger-ui.html")).authenticated()
        ).formLogin((formLogin)-> formLogin.defaultSuccessUrl("/api/employees").permitAll()
                        .loginProcessingUrl("/login").permitAll())
        .logout((logout) -> logout.logoutSuccessUrl("/login"));
     return    http.build();
    }

    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring().antMatchers("/h2-console/**");
    }

}
