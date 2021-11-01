package com.dakshay.support;

import com.dakshay.support.beans.BaseServerConfig;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.dakshay.support.beans.ServerHost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static com.dakshay.support.helpers.CoreUtils.isNotEmpty;
import static java.util.Objects.nonNull;

/**
 * Created by dakshay on 07/06/2021.
 */
@Slf4j
public class Commons {

    private static final String CLUSTER_TYPE = System.getenv("CLUSTER_TYPE");


    public static BaseServerConfig getServerConfigurations(String serverType, String moduleName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String fileName = new StringBuilder("config.yml").toString();
        File file = new File(classLoader.getResource(fileName).getFile());
        ObjectMapper om = new ObjectMapper(new YAMLFactory());
        try {
            List<BaseServerConfig> baseServerConfig = om.readValue(file, new TypeReference<List<BaseServerConfig>>() {});
            log.info("SERVER CONFIGS# {}",baseServerConfig);
            for (BaseServerConfig serverConfig : baseServerConfig) {
                if (moduleName.equals(serverConfig.getModuleName()) && serverType.equals(serverConfig.getType())) {
                    return serverConfig;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public static ServerHost getHostForCurrentCluster(BaseServerConfig baseServerConfig) {
        if(nonNull(baseServerConfig) && isNotEmpty(baseServerConfig.getServerHosts()) ) {
            return baseServerConfig.getServerHosts().stream()
                    .filter(host -> nonNull(host) && CLUSTER_TYPE.equals(host.getClusterType()))
                    .findFirst().orElse(null);
        }
        return null;
    }
}
