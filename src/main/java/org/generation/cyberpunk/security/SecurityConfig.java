package org.generation.cyberpunk.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    //Método para encriptar la contraseña
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/index").permitAll()
                        .requestMatchers("/estudiantes").authenticated()
                        .anyRequest().permitAll());

        return http.build();


    }


    //Crear usuarios para guardar en memoria
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                User.builder().username("usuariorandom").password(passwordEncoder().encode("123random")).roles("ADMIN")
                        .build();
        return new InMemoryUserDetailsManager(user);
    }
}
