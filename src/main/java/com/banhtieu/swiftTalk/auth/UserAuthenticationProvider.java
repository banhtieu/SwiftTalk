package com.banhtieu.swiftTalk.auth;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

/**
 * Created by banhtieu on 9/4/15.
 * User authentication provider
 */
public class UserAuthenticationProvider implements AuthenticationProvider {


    /**
     * Authenticate
     * @param authentication
     * @return
     * @throws AuthenticationException
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        return null;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return false;
    }
}
