package com.banhtieu.swiftTalk.model;

import org.springframework.data.annotation.Id;

import java.security.Principal;

/**
 * Created by banhtieu  9/3/15.
 * The user
 */
public class User implements Principal {

    /**
     * Role of user
     */
    public enum Role {
        USER,
        MODERATOR,
        ADMINISTRATOR
    }

    /**
     * id of the user
     */
    @Id
    private String id;


    /**
     * the screen
     */
    private String screenName;


    /**
     * url to the avatar
     */
    private String avatar;

    /**
     * The facebook Id
     */
    private String facebookId;


    /**
     * Role of this user
     */
    private Role role;


    /**
     * get id of the object
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     * Get the screen name of the user
     * @return
     */
    public String getScreenName() {
        return screenName;
    }


    /**
     * Set screen name
     * @param screenName
     */
    public void setScreenName(String screenName) {
        this.screenName = screenName;
    }

    /**
     * get avatar
     * @return
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * set avatar
     * @param avatar url to avatar
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    /**
     * get facebook id
     * @return
     */
    public String getFacebookId() {
        return facebookId;
    }

    /**
     * Set facebook id
     * @param facebookId facebook id
     */
    public void setFacebookId(String facebookId) {
        this.facebookId = facebookId;
    }

    /**
     * override getName of principal
     * @return the userId
     */
    @Override
    public String getName() {
        return id;
    }


    /**
     * Get the role of this user
     * @return
     */
    public Role getRole() {
        return role;
    }

    /**
     * Set the role of this user
     * @param role
     */
    public void setRole(Role role) {
        this.role = role;
    }
}
