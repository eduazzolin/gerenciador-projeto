package com.example.gerenciador_projeto.config;

import com.example.gerenciador_projeto.controller.JwtTokenFilter;
import com.example.gerenciador_projeto.service.JwtService;
import com.example.gerenciador_projeto.service.SecurityUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;
import java.util.List;

@Configuration
public class SecurityConfiguration {

   private final SecurityUserDetailsService userDetailsService;
   private final JwtService jwtService;

   @Autowired
   public SecurityConfiguration(SecurityUserDetailsService userDetailsService, JwtService jwtService) {
      this.userDetailsService = userDetailsService;
      this.jwtService = jwtService;
   }

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth
              .userDetailsService(userDetailsService)
              .passwordEncoder(passwordEncoder());
   }

   @Bean
   public JwtTokenFilter jwtTokenFilter() {
      return new JwtTokenFilter(jwtService, userDetailsService);
   }

   @Bean
   public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
      http
              .cors() // Enable CORS at Spring Security level
              .and()
              .csrf(AbstractHttpConfigurer::disable)
              .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
              .authorizeHttpRequests(authz -> authz
                      .requestMatchers(
                              new AntPathRequestMatcher("/usuarios/autenticar", HttpMethod.POST.name()),
                              new AntPathRequestMatcher("/usuarios", HttpMethod.POST.name())
                      ).permitAll()
                      .anyRequest().authenticated()
              )
              .addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);

      return http.build();
   }

   @Bean
public CorsConfigurationSource corsConfigurationSource() {
    CorsConfiguration config = new CorsConfiguration();
    config.setAllowCredentials(true);
    config.setAllowedOriginPatterns(Arrays.asList(
        "http://localhost:3000",
        "https://gerenciador-projeto-tarefa.onrender.com"
    ));
    config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
    config.setAllowedHeaders(List.of("*"));
    config.setExposedHeaders(List.of("Authorization")); // If you need to expose any headers
    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    source.registerCorsConfiguration("/**", config);

    return source;
}

}
