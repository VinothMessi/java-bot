package com.generic.javabot.browserfactory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.*;

@Lazy
@Configuration
@Profile("local")
public
class LocalDriver {
    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    @Scope("browserscope")
    public
    WebDriver chrome() {
        WebDriverManager.chromedriver().setup();
        return new ChromeDriver();
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headlessChrome")
    @Scope("browserscope")
    public
    WebDriver headlessChrome() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        return new ChromeDriver(options);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    @Scope("browserscope")
    public
    WebDriver firefox() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headlessFirefox")
    @Scope("browserscope")
    public
    WebDriver headlessFirefox() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--headless");
        return new FirefoxDriver(options);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    @Scope("browserscope")
    public
    WebDriver edge() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}