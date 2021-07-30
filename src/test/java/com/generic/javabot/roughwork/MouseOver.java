package com.generic.javabot.roughwork;

import com.generic.javabot.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public
class MouseOver extends BaseTest {
    @Test
    public
    void mouseOver() {
        browser.get("http://www.way2automation.com/");

        WebElement element1 = browser.findElement(By.xpath("//a[text()='MANUAL TESTING']/parent::li//ul/li[2]/a"));

        element1.click();
    }
}