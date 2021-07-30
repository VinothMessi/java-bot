package com.generic.javabot.browserfactory;

import com.generic.javabot.properties.GridDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@Lazy
@Configuration
@Profile("grid")
public
class RemoteDriver {
    @Autowired
    private GridDetails hub;

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Scope("browserscope")
    public
    WebDriver remoteChrome() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://" + hub.getHost() + ":" + hub.getPort() + "/wd/hub"),
                DesiredCapabilities.chrome());
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Scope("browserscope")
    public
    WebDriver remoteFirefox() throws MalformedURLException {
        return new RemoteWebDriver(new URL("http://" + hub.getHost() + ":" + hub.getPort() + "/wd/hub"),
                DesiredCapabilities.firefox());
    }
}