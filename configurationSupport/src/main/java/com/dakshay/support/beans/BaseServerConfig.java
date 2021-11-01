package com.dakshay.support.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

/**
 * Created by dakshay on 30/05/2021.
 */

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseServerConfig {
    private String id;
    private String type;
    private String moduleName;
    private String dbName;
    private KeyDetails keyDetails;
    private S3Details s3Details;
    private List<ServerHost> serverHosts;
}
