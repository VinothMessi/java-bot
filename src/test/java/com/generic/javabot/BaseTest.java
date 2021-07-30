package com.generic.javabot;

import com.generic.javabot.helpers.SnapShot;
import com.generic.javabot.properties.ProjectDetails;
import com.generic.javabot.workflows.VisaRegistrationWorkFlow;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;

@SpringBootTest
public
class BaseTest extends AbstractTestNGSpringContextTests {
    @Autowired
    protected
    WebDriver browser;

    @Autowired
    protected
    SnapShot snap;

    @Autowired
    protected ProjectDetails project;

    @Autowired
    protected VisaRegistrationWorkFlow forVisaRegistration;

    @AfterClass
    public
    void tearDown() throws Exception {
        forVisaRegistration
                .inTheBrowser(p -> {
                    p.shutDown();
                });
    }
}