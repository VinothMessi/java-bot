package com.generic.javabot.browserfactory;

import com.generic.javabot.helpers.Utilities;
import com.generic.javabot.properties.ProjectDetails;
import com.generic.javabot.properties.ReportDetails;
import com.generic.javabot.properties.TestProjectDetails;
import io.testproject.sdk.DriverBuilder;
import io.testproject.sdk.drivers.web.ChromeDriver;
import io.testproject.sdk.drivers.web.EdgeDriver;
import io.testproject.sdk.drivers.web.FirefoxDriver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Profile;

import java.net.MalformedURLException;
import java.net.URL;

@Lazy
@Configuration
@Profile("testproject")
public
class TestProjectDriver {
    @Autowired
    private TestProjectDetails testProject;

    @Autowired
    private ProjectDetails project;

    @Autowired
    private ReportDetails report;

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "chrome")
    public
    WebDriver tpChrome() throws MalformedURLException {
        return new DriverBuilder<ChromeDriver>(new ChromeOptions())
                .withToken(testProject.getDevToken())
                .withRemoteAddress(new URL("http://" + testProject.getHost() + ":" + testProject.getPort()))
                .withProjectName(project.getName())
                .withJobName(project.getJob())
                .withReportName(report.getName() + "_" + Utilities.currentDateTime())
                .withReportPath(report.getPath())
                .build(ChromeDriver.class);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headlessChrome")
    public
    WebDriver tpHeadlessChrome() throws MalformedURLException {
        return new DriverBuilder<ChromeDriver>(new ChromeOptions().addArguments("--headless"))
                .withToken(testProject.getDevToken())
                .withRemoteAddress(new URL("http://" + testProject.getHost() + ":" + testProject.getPort()))
                .withProjectName(project.getName())
                .withJobName(project.getJob())
                .withReportName(report.getName() + "_" + Utilities.currentDateTime())
                .withReportPath(report.getPath())
                .build(ChromeDriver.class);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "firefox")
    public
    WebDriver tpFirefox() throws MalformedURLException {
        return new DriverBuilder<FirefoxDriver>(new FirefoxOptions())
                .withToken(testProject.getDevToken())
                .withRemoteAddress(new URL("http://" + testProject.getHost() + ":" + testProject.getPort()))
                .withProjectName(project.getName())
                .withJobName(project.getJob())
                .withReportName(report.getName() + "_" + Utilities.currentDateTime())
                .withReportPath(report.getPath())
                .build(FirefoxDriver.class);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "headlessFirefox")
    public
    WebDriver tpHeadlessFirefox() throws MalformedURLException {
        return new DriverBuilder<FirefoxDriver>(new FirefoxOptions().addArguments("--headless"))
                .withToken(testProject.getDevToken())
                .withRemoteAddress(new URL("http://" + testProject.getHost() + ":" + testProject.getPort()))
                .withProjectName(project.getName())
                .withJobName(project.getJob())
                .withReportName(report.getName() + "_" + Utilities.currentDateTime())
                .withReportPath(report.getPath())
                .build(FirefoxDriver.class);
    }

    @Lazy
    @Bean
    @ConditionalOnProperty(name = "browser", havingValue = "edge")
    public
    WebDriver tpEdge() throws MalformedURLException {
        return new DriverBuilder<EdgeDriver>(new EdgeOptions())
                .withToken(testProject.getDevToken())
                .withRemoteAddress(new URL("http://" + testProject.getHost() + ":" + testProject.getPort()))
                .withProjectName(project.getName())
                .withJobName(project.getJob())
                .withReportName(report.getName() + "_" + Utilities.currentDateTime())
                .withReportPath(report.getPath())
                .build(EdgeDriver.class);
    }
}