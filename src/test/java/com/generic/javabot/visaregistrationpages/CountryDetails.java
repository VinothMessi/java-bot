package com.generic.javabot.visaregistrationpages;

import com.generic.javabot.base.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class CountryDetails extends BasePage {
    By fromCountry = By.id("input_46");
    By toCountry = By.id("input_47");

    @Override
    public
    boolean hasItLoaded() {
        return isVisible(fromCountry) && isClickable(fromCountry);
    }

    void fill(String fCountry, String tCountry) throws Exception {
        select("value", fCountry, fromCountry);
        select("value", tCountry, toCountry);
    }
}