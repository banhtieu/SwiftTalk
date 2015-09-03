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
     * @return
     */
    @RequestMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    @RequestMapping("/user/login")
    public String login(@RequestParam String accessToken) {
        Facebook facebook = new FacebookTemplate(accessToken);
        org.springframework.social.facebook.api.User user;
        user = facebook.userOperations().getUserProfile();
        return user.getName();
    }
}
