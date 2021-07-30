package com.generic.javabot.browserfactory;

import com.generic.javabot.helpers.Utilities;
import com.generic.javabot.properties.ProjectDetails;
import com.generic.javabot.properties.GridDetails;
import com.generic.javabot.properties.SelenoidDetails;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;

@Lazy
@Configuration
@Profile("selenoid")
public
class SelenoidDriver {

    @Autowired
    private SelenoidDetails selenoid;

    @Autowired
    private ProjectDetails project;

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Scope("browserscope")
    public
    WebDriver selenoidChrome() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "chrome");
        capabilities.setCapability("browserVersion", selenoid.getVersion());
        capabilities.setCapability("enableVNC", selenoid.isEnableVNC());
        capabilities.setCapability("enableVideo", selenoid.isEnableVideo());
        capabilities.setCapability("videoName",
                selenoid.getVideoFile() + "_" + Utilities.currentDateTime() + selenoid.getVideoFormat());
        capabilities.setCapability("enableLog", selenoid.isEnableLog());
        capabilities.setCapability("logName",
                selenoid.getLogFile() + "_" + Utilities.currentDateTime() + selenoid.getLogFormat());
        return new RemoteWebDriver(new URL("http://" +
                selenoid.getHost() + ":" + selenoid.getPort() + "/wd/hub"), capabilities);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Scope("browserscope")
    public
    WebDriver selenoidFirefox() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("browserVersion", selenoid.getVersion());
        capabilities.setCapability("enableVNC", selenoid.isEnableVNC());
        capabilities.setCapability("enableVideo", selenoid.isEnableVideo());
        capabilities.setCapability("videoName",
                selenoid.getVideoFile() + "_" + Utilities.currentDateTime() + selenoid.getVideoFormat());
        capabilities.setCapability("enableLog", selenoid.isEnableLog());
        capabilities.setCapability("logName",
                selenoid.getLogFile() + "_" + Utilities.currentDateTime() + selenoid.getLogFormat());
        return new RemoteWebDriver(new URL("http://" +
                selenoid.getHost() + ":" + selenoid.getPort() + "/wd/hub"), capabilities);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Scope("browserscope")
    public
    WebDriver selenoidEdge() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "MicrosoftEdge");
        capabilities.setCapability("browserVersion", selenoid.getVersion());
        capabilities.setCapability("enableVNC", selenoid.isEnableVNC());
        capabilities.setCapability("enableVideo", selenoid.isEnableVideo());
        capabilities.setCapability("videoName",
                selenoid.getVideoFile() + "_" + Utilities.currentDateTime() + selenoid.getVideoFormat());
        capabilities.setCapability("enableLog", selenoid.isEnableLog());
        capabilities.setCapability("logName",
                selenoid.getLogFile() + "_" + Utilities.currentDateTime() + selenoid.getLogFormat());
        return new RemoteWebDriver(new URL("http://" +
                selenoid.getHost() + ":" + selenoid.getPort() + "/wd/hub"), capabilities);
    }
}