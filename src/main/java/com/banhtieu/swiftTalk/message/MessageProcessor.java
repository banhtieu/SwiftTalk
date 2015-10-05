package com.banhtieu.swiftTalk.message;

import com.banhtieu.swiftTalk.model.Message;

/**
 * Created by banhtieu on 10/5/2015.
 */
public interface MessageProcessor {

    /**
     * Handle message and add additional data
     * @param message the input message
     */
    void handleMessage(Message message);
}
