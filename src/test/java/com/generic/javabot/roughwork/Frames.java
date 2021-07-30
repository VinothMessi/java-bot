package com.generic.javabot.roughwork;

import com.generic.javabot.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public
class Frames extends BaseTest {
    @Test
    public
    void frames() {
        browser.get("https://vins-udemy.s3.amazonaws.com/ds/main.html");

        browser.switchTo().frame("a");

        WebElement element = browser.findElement(By.name("fn"));

        element.sendKeys("Lionel");
    }
}