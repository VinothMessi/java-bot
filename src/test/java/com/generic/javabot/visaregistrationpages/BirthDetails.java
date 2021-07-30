package com.generic.javabot.visaregistrationpages;

import com.generic.javabot.base.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class BirthDetails extends BasePage {
    By month = By.id("input_24_month");
    By day = By.id("input_24_day");
    By year = By.id("input_24_year");

    @Override
    public
    boolean hasItLoaded() {
        return isVisible(month) && isClickable(month);
    }

    void fill(String mOnth, String dAy, String yEar) throws Exception {
        select("value", mOnth, month);
        select("value", dAy, day);
        select("value", yEar, year);
    }
}