package com.banhtieu.swiftTalk.services;

import com.banhtieu.swiftTalk.model.User;
import java.util.List;

import com.banhtieu.swiftTalk.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.facebook.api.Facebook;
import org.springframework.social.facebook.api.impl.FacebookTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * Created by banhtieu on 9/3/15.
 * The user service that handle all
 */
@RestController
public class UserService {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpSession session;
    private User currentUser;

    /**
     * find all users in repository
     * @return
     */
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    /**
     * Logged in as a user
     * @param accessToken
     * @return
     */
    @RequestMapping("/user/login")
    public User login(@RequestParam String accessToken) {

        org.springframework.social.facebook.api.User profile = getProfile(accessToken);

        User user = userRepository.findByFacebookId(profile.getId());

        if (user == null) {
            user = new User();
            user.setFacebookId(profile.getId());
            user.setScreenName(profile.getName());

            userRepository.save(user);
        }

        setCurrentUser(user);

        return user;
    }


    /**
     * Get the current user
     * @return current logged in user
     */
    @RequestMapping("/user/me")
    public User getCurrentUser() {
        if (currentUser == null) {
            try {
                String userId = (String) session.getAttribute("currentUser");
                currentUser = userRepository.findOne(userId);
            } catch (Exception exception) {
                currentUser = null;
            }
        }

        return currentUser;
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

    /**
     * set the current user
     * @param currentUser current user
     */
    protected void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
        session.setAttribute("currentUser", currentUser.getId());
    }
}
