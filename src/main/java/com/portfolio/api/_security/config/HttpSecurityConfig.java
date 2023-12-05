package com.portfolio.api._security.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AuthorizeHttpRequestsConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;

import com.portfolio.api._security.jwt.JwtAuthenticationFilter;
import com.portfolio.api._security.utils.Permission;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class HttpSecurityConfig {

    @Autowired
    private JwtAuthenticationFilter jwtFilter;

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        
        http.csrf(csrf -> csrf.disable())
        .cors(cors -> cors.configurationSource(request -> {
            CorsConfiguration config = new CorsConfiguration();
            config.setAllowedOrigins(Arrays.asList("https://fir-portfolio-220a9.web.app", "http://localhost:3000"));
            config.setAllowCredentials(true);
            config.applyPermitDefaultValues();
            return config;
            }))
            .authorizeHttpRequests(builderRequestMatchers())
            .sessionManagement(sesion -> sesion.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

            

            return http.build();
    }

     private static Customizer<AuthorizeHttpRequestsConfigurer<HttpSecurity>.AuthorizationManagerRequestMatcherRegistry> builderRequestMatchers() {
        return authorize -> {
                //public
                authorize.requestMatchers("/auth/signin").permitAll();
                
                //protected
                authorize.requestMatchers("/auth/signup").hasAuthority(Permission.ALL_ACCESS.name());
                authorize.requestMatchers(HttpMethod.DELETE,"/**").hasAuthority(Permission.ALL_ACCESS.name());
                authorize.requestMatchers(HttpMethod.POST,"/**").hasAuthority(Permission.ALL_ACCESS.name());
                authorize.requestMatchers(HttpMethod.PUT,"/**").hasAuthority(Permission.ALL_ACCESS.name());
                
                //private
                authorize.anyRequest().authenticated();
            };
    }

}

