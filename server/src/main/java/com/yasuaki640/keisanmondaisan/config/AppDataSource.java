package com.yasuaki640.keisanmondaisan.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.datasource")
public class AppDataSource {

    public static final String DRIVER = "org.postgresql.Driver";

    public static String url;

    public static String username;

    public static String password;
}
