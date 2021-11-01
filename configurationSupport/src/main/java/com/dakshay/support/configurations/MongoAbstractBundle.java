package com.dakshay.support.configurations;

import com.dakshay.support.Commons;
import com.dakshay.support.beans.BaseServerConfig;
import com.dakshay.support.beans.ServerHost;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;


import java.util.List;

import static com.dakshay.support.helpers.CoreUtils.*;
import static java.util.Arrays.asList;
import static java.util.Objects.nonNull;

/**
 * Created by dakshay on 04/05/2021.
 */
@Slf4j
public abstract class MongoAbstractBundle<T> {

    private final String moduleName;
    private static final String DEFAULT_HOST = "localhost";
    private static final String DEFAULT_DB = "default_article";
    private static final int DEFAULT_PORT = 27017;
    @Autowired
    private Commons commons;

    public MongoAbstractBundle(String moduleName) {
        this.moduleName = moduleName;
    }

    protected MongoTemplate getMongoTemplate() {
        MongoClientSettings.Builder settingsBuilder = MongoClientSettings.builder();
        BaseServerConfig baseServerConfig = commons.getServerConfigurations("MONGO", moduleName);
        String dbName = new StringBuilder("default").append(moduleName).toString();
        if(nonNull(baseServerConfig) && isNotBlank(baseServerConfig.getDbName())){
            dbName = baseServerConfig.getDbName();
        } else{
            dbName = DEFAULT_DB;
        }
        ServerHost serverHost = commons.getHostForCurrentCluster(baseServerConfig);
        if(nonNull(serverHost)) {
            String host = serverHost.getHost();
            int port = serverHost.getPort();
            ServerAddress serverAddress = null;
            if(isBlank(host)){
                host = DEFAULT_HOST;
            }
            if(port <= 0 || port> 65535) {
                port = DEFAULT_PORT;
            }
            serverAddress = new ServerAddress(host,port);
            List<ServerAddress> serverAddresses = asList(serverAddress);
            settingsBuilder.applyToClusterSettings(clusterBuilder -> clusterBuilder.hosts(serverAddresses));
        }
        MongoClient mongoClient = MongoClients.create(settingsBuilder.build());
//        MongoClient mongoClient = MongoClients.create("mongodb://127.0.0.1:27017");
        MongoTemplate mongoTemplate = new MongoTemplate(mongoClient,dbName);
        return mongoTemplate;
    }



}
