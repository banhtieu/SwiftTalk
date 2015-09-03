package com.banhtieu.swiftTalk.model;

import org.springframework.data.annotation.Id;

/**
 * Created by banhtieon 9/3/15.
 */
public class User {


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
}
