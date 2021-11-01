package com.dakshay.support.beans;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

/**
 * Created by dakshay on 30/05/2021.
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerHost {
    private String type;
    private String clusterType;
    private String host;
    private int port;
    private String protocol;
    private String username;
    private String password;

}
