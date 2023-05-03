package br.com.softblue.bluefood.infrastructure.web.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig  {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/img/**","/css/**","/js/**","/public" , "/sbpay").permitAll()
                .requestMatchers("/cliente/**").hasRole(Role.CLIENTE.toString())
                .requestMatchers("/restaurante/**").hasRole(Role.RESTAURANTE.toString())
                .anyRequest().authenticated()
                .and().
                formLogin()
                    .loginPage("/login")
                    .failureUrl("/login-error")
                    //.successHandler(null)
                    .permitAll()
                .and()
                .logout().logoutUrl("/logout")
                .permitAll();

        return http.build();
    }
}
