package ru.sixzr.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//  @Autowired
//  public UserService userService;

  @Autowired
  public PasswordEncoder passwordEncoder;

//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//    auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
//  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.csrf().disable();

    http.authorizeRequests()
            .antMatchers("/register").permitAll()
            .antMatchers("/profile").authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/profile")
            .usernameParameter("email")
            .passwordParameter("password")
            .failureUrl("/login?error").permitAll();
  }
}
