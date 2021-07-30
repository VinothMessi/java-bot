package com.generic.javabot.visaregistrationpages;

import com.generic.javabot.base.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class HomePage extends BasePage {
    By pageSection = By.xpath("//form[@class='jotform-form']");
    By visaForm = By.xpath("//div[@class='form-all']");

    public
    void launch(String url) {
        maximize();
        navigateTo(url);
    }

    public
    void shutDown() {
        quit();
    }

    @Override
    public
    boolean hasItLoaded() {
        return isVisible(pageSection) && isClickable(visaForm);
    }

    public
    String pageTitle() {
        return getPageTitle();
    }
}