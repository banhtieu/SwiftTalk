package com.banhtieu.swiftTalk.repository;

import com.banhtieu.swiftTalk.model.Message;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Get the message
 * Created by banhtieu on 10/5/2015.
 */
public interface MessageRepository extends MongoRepository<Message, String> {
}
