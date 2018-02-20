/**
 * 
 */
package com.example.resources.config.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.TokenStore;

@Configuration 
@EnableResourceServer
public class ResourceConfig extends ResourceServerConfigurerAdapter {
    
	@Value("${security.oauth2.resource.id}")
    private String resourceId;

    @Autowired
    private DefaultTokenServices tokenServices;

    @Autowired
    private TokenStore tokenStore;

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources
                .resourceId(resourceId)
                .tokenServices(tokenServices)
                .tokenStore(tokenStore);
    }
    
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .anonymous().disable()
                .authorizeRequests()
                .antMatchers(org.springframework.http.HttpMethod.OPTIONS).permitAll()
                // when restricting access to 'Roles' you must remove the "ROLE_" part role
                // for "ROLE_USER" use only "USER"
                .antMatchers("/api/hello").access("hasAnyRole('USER')")          
                .antMatchers("/api/admin").hasRole("ADMIN")
                // restricting all access to /api/** to authenticated users
                .anyRequest().authenticated();
                //.antMatchers("/api/**").authenticated();
        
    }

   /* private static class OAuthRequestedMatcher implements RequestMatcher {
        public boolean matches(HttpServletRequest request) {
            // Determine if the resource called is "/api/**"
            String path = request.getServletPath();
            if ( path.length() >= 5 ) {
              path = path.substring(0, 5);
              boolean isApi = path.equals("/api/");
              return isApi;
            } else return false;
        }
    }*/
}