package com.generic.javabot.browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

@Lazy
@Configuration
@Scope("browserscope")
public
class WebDriverWaitConfig {
    @Value("${timeOut}")
    private long timeOut;

    @Bean
    public
    WebDriverWait wait(WebDriver driver) {
        return new WebDriverWait(driver, this.timeOut);
    }
}