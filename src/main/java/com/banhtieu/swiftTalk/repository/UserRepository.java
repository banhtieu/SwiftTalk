package com.banhtieu.swiftTalk.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import com.banhtieu.swiftTalk.model.User;

/**
 * Created by banhtieu on 9/3/15.
 *
 * The User repository that handle all user
 */
public interface UserRepository extends MongoRepository<User, String> {

    /**
     * find a user in the repository by its facebookId
     * @param facebookId the facebookId
     * @return the matched user
     */
    User findByFacebookId(String facebookId);
}
