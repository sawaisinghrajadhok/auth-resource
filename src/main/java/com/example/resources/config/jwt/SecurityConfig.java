package com.example.resources.config.jwt;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
	/*@Override
    protected void configure(HttpSecurity http) throws Exception {
    	 http
         .formLogin().disable() // disable form authentication
         .anonymous().disable() // disable anonymous user
         .httpBasic().and()
         // restricting access to authenticated users
         .authorizeRequests().anyRequest().authenticated();
    }*/

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication() // creating user in memory
                //.withUser("user")
                   // .password("password").roles("USER")
                //.and()
                .withUser("admin")
                    .password("password").authorities("ROLE_ADMIN");*/
    }
    
    /*@Override
    public void configure(WebSecurity webSecurity) {
    	webSecurity.ignoring().antMatchers(HttpMethod.POST, "/oauth/token/**");
    }*/

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}