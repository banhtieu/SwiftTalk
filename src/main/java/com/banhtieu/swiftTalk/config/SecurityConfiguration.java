package com.banhtieu.swiftTalk.config;

import com.banhtieu.swiftTalk.auth.UserAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

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

        http.authorizeRequests()
                .anyRequest()
                .permitAll()
            .and()
                .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
            .csrf()
                .csrfTokenRepository(csrfTokenRepository());

    }

    /**
     * the token repository for csrf filtering
     * @return
     */
    private CsrfTokenRepository csrfTokenRepository() {
        HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
        repository.setHeaderName("X-XSRF-TOKEN");
        return repository;
    }

    /**
     *
     * @param auth the authentication
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(new UserAuthenticationProvider());
    }
}
