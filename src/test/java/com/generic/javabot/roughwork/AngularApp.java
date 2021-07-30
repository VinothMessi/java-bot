package com.generic.javabot.roughwork;

import com.generic.javabot.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public
class AngularApp extends BaseTest {
    @Test
    public
    void angularApp() throws InterruptedException {
        browser.get("https://citrusbug.com/");

        browser.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        browser.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);

        WebElement element1 = browser.findElement(By.xpath("//div[@class='heading-content']"));
        WebElement element2 = browser.findElement(By.xpath("//p[text()='We design great experiences for your digital journey']"));

        WebDriverWait wait = new WebDriverWait(browser, 30);
        wait.until(ExpectedConditions.elementToBeClickable(element1));
       /* wait.until(ExpectedConditions.visibilityOf(element1));
        wait.until(ExpectedConditions.elementToBeClickable(element2));
*/
        /*Thread.sleep(3000);*/
        System.out.println(element1.getText().trim());
        System.out.println(element2.getText().trim());
    }
}