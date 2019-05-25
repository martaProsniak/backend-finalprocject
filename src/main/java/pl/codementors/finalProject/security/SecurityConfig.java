package pl.codementors.finalProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import pl.codementors.finalProject.models.LocalUserRole;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     private LocalUserDetailsService localUserDetailsService;

     @Override
     protected void configure(HttpSecurity http) throws Exception {

          http.csrf().disable().cors();

          http
                  .authorizeRequests()
                  .antMatchers("/", "/users**").permitAll()
                  .antMatchers("/products**", "/login", "/users/add").permitAll()
                  .antMatchers("/cart**").permitAll()
                  .and()
                  .formLogin()
                  //.defaultSuccessUrl("/products", true)
                  .and()
                  .logout()
                  .deleteCookies("JSESSIONID");
     }

     @Autowired
     private Environment env;

     @Bean
     CorsConfigurationSource corsConfigurationSource() {
          UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
          CorsConfiguration config = new CorsConfiguration();
          config.setAllowCredentials(true);
          config.addAllowedOrigin("http://localhost:4200");
          config.addAllowedHeader("*");
          config.addAllowedMethod("*");
          source.registerCorsConfiguration("/**", config);
          return source;
     }

     @Autowired
     public void configureGlobal(AuthenticationManagerBuilder auth) {
          auth.authenticationProvider(authenticationProvider(passwordEncoder()));
     }

     @Bean
     public DaoAuthenticationProvider authenticationProvider(PasswordEncoder passwordEncoder) {
          DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
          authProvider.setUserDetailsService(localUserDetailsService);
          authProvider.setPasswordEncoder(passwordEncoder);
          return authProvider;
     }

     @Bean
     public PasswordEncoder passwordEncoder(){
          return new BCryptPasswordEncoder();
     }
}