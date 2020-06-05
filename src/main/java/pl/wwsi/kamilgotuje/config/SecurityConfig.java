package pl.wwsi.kamilgotuje.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/index").permitAll()
                .antMatchers("/przepisy").permitAll()
                .antMatchers("/dajprzepis/{id}").permitAll()
                .antMatchers("/nowyprzepis").permitAll()
                .antMatchers("/dodajprzepis").permitAll()
                .antMatchers("/nowykomentarz").permitAll()
                .antMatchers("/dodajkomentarz").permitAll()
                .and()
                .authorizeRequests()
                .antMatchers("/new-recipe").hasRole("USER")
                .antMatchers("/new-comment").hasRole("USER")
                .anyRequest().authenticated()
                .and()
                .httpBasic()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("{noop}password")
                .roles("USER")
                .and()
                .withUser("aga")
                .password("{noop}password")
                .roles("MANAGER");
    }
}
