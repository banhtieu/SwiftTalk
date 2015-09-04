package com.banhtieu.swiftTalk.services;

import com.banhtieu.swiftTalk.auth.UserAuthentication;
import com.banhtieu.swiftTalk.model.User;

import java.security.Principal;
import java.util.List;

import com.banhtieu.swiftTalk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by banhtieu on 9/3/15.
 * The user service that handle all
 */
@RestController
public class UserService {


    @Autowired
    private UserRepository userRepository;

    /**
     * find all users in repository
     * @return all user in database
     */
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    /**
     * Logged in as a user
     * @return the logged in user
     */
    @RequestMapping("/user/login")
    public User login(@RequestParam String accessToken) {

        org.springframework.social.facebook.api.User profile = getProfile(accessToken);

        User user = null;

        if (profile != null) {
            user = userRepository.findByFacebookId(profile.getId());


            if (user == null) {
                user = new User();
                user.setFacebookId(profile.getId());
                user.setScreenName(profile.getName());
                user.setAvatar(String.format("https://graph.facebook.com/%s/picture?type=large", profile.getId()));
                user.setRole(User.Role.USER);

                userRepository.save(user);
            }

            UserAuthentication userAuthentication = new UserAuthentication(user);
            SecurityContext context = SecurityContextHolder.getContext();
            context.setAuthentication(userAuthentication);
        }

        return user;
    }


    /**
     * Get the current user
     * @param principal the current user
     * @return current logged in user
     */
    @RequestMapping("/user/me")
    public User getCurrentUser(Principal principal) {
        return userRepository.findOne(principal.getName());
    }

    /**
     * Get User Profile
     * @param accessToken the facebook access token
     * @return the facebook profile of logged in user
     */
    private org.springframework.social.facebook.api.User getProfile(String accessToken) {
        Facebook facebook = new FacebookTemplate(accessToken);
        return facebook.userOperations().getUserProfile();
    }
}
