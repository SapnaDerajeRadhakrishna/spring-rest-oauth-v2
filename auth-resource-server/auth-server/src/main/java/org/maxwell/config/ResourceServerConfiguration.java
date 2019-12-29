package org.maxwell.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/oauth/token", "/oauth/authorize**", "/public")
            .permitAll();
        http.requestMatchers()
            .antMatchers("/private")
            .and()
            .authorizeRequests()
            .antMatchers("/private")
            .access("hasRole('USER')")
            .and()
            .requestMatchers()
            .antMatchers("/admin")
            .and()
            .authorizeRequests()
            .antMatchers("/admin")
            .access("hasRole('ADMIN')");
    }

}
