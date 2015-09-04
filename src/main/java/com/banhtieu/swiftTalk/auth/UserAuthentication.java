package com.banhtieu.swiftTalk.auth;

import com.banhtieu.swiftTalk.model.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by banhtieu on 9/4/15.
 */
public class UserAuthentication implements Authentication {


    public class UserGrantedAuthority implements GrantedAuthority {

        private User.Role role;

        UserGrantedAuthority(User.Role role) {
            this.role = role;
        }

        @Override
        public String getAuthority() {
            return role.name();
        }
    }

    /**
     * The logged in user
     */
    private User user;

    private List<UserGrantedAuthority> grantedAuthorities;


    /**
     * create a user authentication
     * @param user
     */
    public UserAuthentication(User user) {
        this.user = user;
        grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new UserGrantedAuthority(user.getRole()));
    }


    /**
     * get authorities
     * @return all authorities
     */

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {

        return grantedAuthorities;
    }

    /**
     *
     * @return
     */
    @Override
    public Object getCredentials() {
        return user.getFacebookId();
    }

    /**
     *
     * @return details information
     */
    @Override
    public Object getDetails() {
        return user;
    }

    /**
     *
     * @return the logged in principle
     */
    @Override
    public Object getPrincipal() {
        return user;
    }

    /**
     * get if user is authenticated
     * @return
     */
    @Override
    public boolean isAuthenticated() {
        return user != null;
    }


    /**
     * set authenticated
     * @param b
     * @throws IllegalArgumentException
     */
    @Override
    public void setAuthenticated(boolean b) throws IllegalArgumentException {

    }

    /**
     * get name of the user
     * @return
     */
    @Override
    public String getName() {
        return user.getName();
    }
}
