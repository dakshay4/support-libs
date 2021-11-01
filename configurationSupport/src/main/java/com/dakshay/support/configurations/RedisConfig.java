package com.dakshay.support.configurations;

import com.dakshay.support.Commons;
import com.dakshay.support.beans.BaseServerConfig;
import com.dakshay.support.beans.ServerHost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisShardInfo;

import static java.util.Objects.nonNull;

/**
 * Created by dakshay on 06/06/2021.
 */

@Component
@Slf4j
public class RedisConfig {

    private static final String DEFAULT_HOST = "localhost";
    private static final int DEFAULT_PORT = 6379;
    private static final String DEFAULT_DB = "default";


    @Autowired
    private Commons commons;


    public JedisConnectionFactory createJedisConnection(){
        BaseServerConfig baseServerConfig = commons.getServerConfigurations("REDIS","asa");
        String dbName = DEFAULT_DB;
        if(nonNull(baseServerConfig)) {
            dbName = baseServerConfig.getDbName();
        }
        ServerHost serverHost = commons.getHostForCurrentCluster(baseServerConfig);
        String host = DEFAULT_HOST, username=null, password=null;
        int port = DEFAULT_PORT;
        if(nonNull(serverHost)) {
            port = serverHost.getPort();
            host = serverHost.getHost();
            username = serverHost.getUsername();
            password = serverHost.getPassword();
        }
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration(host,port);
//        redisStandaloneConfiguration.setUsername(username);
//        redisStandaloneConfiguration.setPassword(password);
        log.info("redisStandaloneConfiguration# {}:{}",redisStandaloneConfiguration.getHostName(),redisStandaloneConfiguration.getPort());
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        return jedisConnectionFactory;
    }
}
