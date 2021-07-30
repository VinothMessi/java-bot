package com.generic.javabot.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@ConfigurationProperties("selenoid")
@Data
@NoArgsConstructor
@AllArgsConstructor
public
class SelenoidDetails {
    private String version;
    private String host;
    private int port;
    private boolean enableVNC;
    private boolean enableVideo;
    private String videoFile;
    private String videoFormat;
    private boolean enableLog;
    private String logFile;
    private String logFormat;
}