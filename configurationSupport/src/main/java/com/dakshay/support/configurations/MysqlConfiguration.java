package com.dakshay.support.configurations;

import com.dakshay.Exception.*;
import com.dakshay.support.Commons;
import com.dakshay.support.beans.BaseServerConfig;
import com.dakshay.support.beans.ServerHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * Created by dakshay on 21/09/2021.
 */
@Component
public class MysqlConfiguration {

    private final String serverType= "MYSQL";

    public DriverManagerDataSource getMysqlWriteConnection(String moduleName) throws DException{
        BaseServerConfig baseServerConfig = Commons.getServerConfigurations(serverType, moduleName);
        String dataBaseName = baseServerConfig.getDbName();
        ServerHost serverHost = Commons.getHostForCurrentCluster(baseServerConfig);
        if(Objects.nonNull(serverHost)) {
            String userName = serverHost.getUsername();
            String password = serverHost.getPassword();
            String host = serverHost.getHost();
            int port = serverHost.getPort();
            DriverManagerDataSource dataSource = new DriverManagerDataSource();
            dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
            StringBuilder url = new StringBuilder("jdbc:mysql://");
            url.append(host).append(":")
                    .append(port).append("/")
                    .append(dataBaseName).append("?")
                    .append("createDatabaseIfNotExist=").append("true");
            dataSource.setUrl(url.toString());
            return dataSource;
        } else {
            throw new DException(ErrorCode.EXTRA_DATABASE_VALUES,ErrorMessage.EXTRA_DATABASE_VALUES);
        }
    }
}
