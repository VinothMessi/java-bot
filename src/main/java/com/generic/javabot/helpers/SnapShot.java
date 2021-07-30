package com.generic.javabot.helpers;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Lazy
@Component
public
class SnapShot {
    @Value("${snapshot.path}")
    private String snapPath;

    @Autowired
    private ApplicationContext ctx;

    public
    void savePageAs(String filename) {
        Shutterbug
                .shootPage(ctx.getBean(WebDriver.class), Capture.FULL_SCROLL, 500, true)
                .withName(filename).save(snapPath);
    }

    public
    void saveElementAs(String filename, WebElement element) {
        Shutterbug
                .shootElement(ctx.getBean(WebDriver.class), element)
                .withName(filename).save(snapPath);
    }
}