package com.generic.javabot.roughwork;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import com.generic.javabot.BaseTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import ru.yandex.qatools.ashot.Screenshot;

import java.io.IOException;

public
class FullPageScreenShot extends BaseTest {
    Screenshot screenshot;

    @Test
    public
    void angularApp() throws InterruptedException, IOException {
        browser.get("https://www.syscloud.com/");
        browser.manage().window().maximize();
        WebElement element = browser.findElement(By.id("navbar"));

        Shutterbug
                .shootElement(browser, element)
                .withName("logo").save("C:\\Passion\\TestProject\\opensdk\\java-bot\\results\\reports\\snaps\\");

        Shutterbug
                .shootPage(browser, Capture.FULL_SCROLL, 500, true)
                .withName("fullPage").save("C:\\Passion\\TestProject\\opensdk\\java-bot\\results\\reports\\snaps\\");
    }
}