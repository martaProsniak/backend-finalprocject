package pl.codementors.finalProject.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.codementors.finalProject.models.LocalUserRole;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

     @Autowired
     private LocalUserDetailsService localUserDetailsService;

     @Override
     protected void configure(HttpSecurity http) throws Exception {
          http
                  .cors()
                  .and()
                  .csrf().disable()
                  .authorizeRequests()
                  .antMatchers("/users**").hasRole(LocalUserRole.ADMIN.name())
                  .antMatchers("/products", "/login").permitAll()
                  .antMatchers("/cart**").hasRole(LocalUserRole.USER.name())
                  .anyRequest().authenticated()
                  .and()
                  .formLogin()
                  .defaultSuccessUrl("/products", true)
                  .and()
                  .logout()
                  .deleteCookies("JSESSIONID");
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