package com.example.Task3.Authenticated.Book.Management.System.Configuration;


import com.example.Task3.Authenticated.Book.Management.System.Security.JwtAuthenticationFilter;
import com.example.Task3.Authenticated.Book.Management.System.Service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;

import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {

//@Bean
//public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//    System.out.println("######## SECURITY FILTER CHAIN CREATED ########");
//    http
//            .csrf(AbstractHttpConfigurer::disable)
//            .authorizeHttpRequests(auth -> auth
//                    .anyRequest().permitAll()
//            );
//
//    return http.build();
//}
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity httpSecurity) throws Exception{
        httpSecurity
                .csrf(AbstractHttpConfigurer::disable)
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/api/v1/users/register",
                        "/api/v1/users/login").permitAll()
                        .anyRequest().authenticated()
                ).addFilterBefore(authFilter(), UsernamePasswordAuthenticationFilter.class)
                ; // or .httpBasic()

        return httpSecurity.build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        AuthenticationManager manager =  configuration.getAuthenticationManager();
        System.out.println(
                "$$$$$$$$$$$$$$$$$$$$$$$AUTHENTICATION MANAGER = $$$$$$$$$$$$$$$$$$$$$$$$$$$$$4" +
                        manager.getClass().getName()
        );
        return manager;
    }

    @Bean
    public JwtAuthenticationFilter authFilter(){
        return new JwtAuthenticationFilter();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}


