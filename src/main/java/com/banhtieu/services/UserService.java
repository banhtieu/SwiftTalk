package com.banhtieu.services;

import com.banhtieu.model.User;
import com.banhtieu.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by banhtieu on 9/3/15.
 * The user service that handle all
 */
@RestController
public class UserService {

    /**
     * The user repository
     */
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

}
