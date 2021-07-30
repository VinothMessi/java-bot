package com.generic.javabot.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.TimeUnit;

public
abstract
class BasePage {
    @Value("${timeOut}")
    private long timeOut;

    @Autowired
    protected WebDriver browser;

    @Autowired
    protected WebDriverWait wait;

    @PostConstruct
    void init() {
        browser.manage().timeouts().implicitlyWait(this.timeOut, TimeUnit.SECONDS);
        browser.manage().timeouts().pageLoadTimeout(this.timeOut, TimeUnit.SECONDS);
    }

    public
    abstract
    boolean hasItLoaded();

    protected
    void maximize() {
        browser.manage().window().maximize();
    }

    protected
    void close() {
        browser.close();
    }

    protected
    void quit() {
        browser.quit();
    }

    protected
    void navigateTo(String url) {
        browser.navigate().to(url);
    }

    protected
    String getPageTitle() {
        return browser.getTitle();
    }

    protected
    WebElement identify(By by) {
        return browser.findElement(by);
    }

    protected
    List<WebElement> identifyAll(By by) {
        return browser.findElements(by);
    }

    protected
    boolean isVisible(By by) {
        return identify(by).isDisplayed();
    }

    protected
    boolean isClickable(By by) {
        return identify(by).isEnabled();
    }

    protected
    void clickOn(By by) {
        identify(by).click();
    }

    protected
    void type(String text, By by) {
        identify(by).sendKeys(text);
    }

    protected
    String getTextFrom(By by) {
        return identify(by).getText();
    }

    protected
    void select(String action, String text, By by) throws Exception {
        Select dropDown = new Select(identify(by));
        switch (action) {
            case "text":
                dropDown.selectByVisibleText(text.trim());
                break;
            case "value":
                dropDown.selectByValue(text.trim());
                break;
            case "index":
                dropDown.selectByIndex(Integer.parseInt(text.trim()));
                break;
            default:
                throw new Exception("Invalid condition (or) value");
        }
    }
}