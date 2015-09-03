package com.banhtieu.swiftTalk.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.support.ConnectionFactoryRegistry;
import org.springframework.social.facebook.connect.FacebookConnectionFactory;

/**
 * Created by banhtieu on 9/3/15.
 */
@Configuration
public class FacebookConfiguration {

    @Bean
    public ConnectionFactoryLocator connectionFactoryLocator() {
        ConnectionFactoryRegistry registry = new ConnectionFactoryRegistry();
        registry.addConnectionFactory(new FacebookConnectionFactory(
                System.getenv("FACEBOOK_APP_ID"),
                System.getenv("FACEBOOK_APP_SECRET")));
        return registry;
    }
}
