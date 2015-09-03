package com.banhtieu.swiftTalk.config;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

/**
 * Created by banhtieu on 9/3/15.
 */
@Configuration
public class MongoDBConfiguration extends AbstractMongoConfiguration {

    /**
     *
     * @return
     */
    @Override
    protected String getDatabaseName() {
        String databaseName = System.getenv("DATABASE_NAME");

        if (databaseName == null) {
            databaseName = "database";
        }

        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        String connectionString = System.getenv("MONGO_CONNECTION");

        if (connectionString == null) {
            connectionString = "127.0.0.1";
        }

        return new MongoClient(connectionString);
    }
}
