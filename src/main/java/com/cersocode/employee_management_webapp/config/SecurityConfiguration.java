package com.cersocode.employee_management_webapp.config;

import com.cersocode.employee_management_webapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Autowired
    private UserService userService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain SecurityfilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests((requests) -> requests
                        .requestMatchers("/registration/**").permitAll()
                        .requestMatchers("/js/**").permitAll()
                        .requestMatchers("/css/**").permitAll()
                        .requestMatchers("/img/**").permitAll()
                )
                .formLogin((form) -> form
                        .loginPage("/login")
                        .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .permitAll()
                );
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(passwordEncoder());
    }
}
 /* Explicación:
 * @Configuration: Marca esta clase como una fuente de configuración de Spring.
 * @EnableWebSecurity: Habilita las funciones de seguridad web de Spring.
 * passwordEncoder(): Este método define un bean de codificador de contraseñas BCrypt, que es un algoritmo seguro para cifrar y verificar contraseñas.
 * filterChain(HttpSecurity http): Aquí se configuran las reglas de seguridad para la aplicación. Se especifica qué rutas deben estar protegidas y cuáles son públicas.
 *         authorizeHttpRequests: Define las rutas que se permiten sin autenticación, como /registration, y los recursos estáticos.
 * formLogin(): Configura el inicio de sesión personalizado, incluyendo una página de inicio de sesión propia.
 * logout(): Configura el cierre de sesión, permitiendo que los usuarios cierren sesión utilizando una URL específica.
 * configureGlobal(): Configura el gestor de autenticación con el servicio de usuario y el codificador de contraseñas.
 *  */


