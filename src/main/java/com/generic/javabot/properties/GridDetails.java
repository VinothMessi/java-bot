package com.generic.javabot.properties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Lazy
@Configuration
@ConfigurationProperties("grid")
@Data
@NoArgsConstructor
@AllArgsConstructor
public
class GridDetails {
    private String host;
    private int port;
}