package com.banhtieu.swiftTalk.config;

import com.banhtieu.swiftTalk.auth.UserAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by banhtieu on 9/4/15.
 *
 * The security configuration
 */
@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    /**
     * Configure security for the website
     * @param http configure security
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);

        http.authorizeRequests().anyRequest().permitAll();

    }


    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new UserAuthenticationProvider());
    }
}
