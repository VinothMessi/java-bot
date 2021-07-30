package com.generic.javabot.visaregistrationpages;

import com.generic.javabot.base.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class ContactDetails extends BasePage {
    By userEmail = By.id("input_6");
    By areaCode = By.id("input_27_area");
    By phoneNumber = By.id("input_27_phone");

    @Override
    public
    boolean hasItLoaded() {
        return isVisible(userEmail) && isClickable(userEmail);
    }

    void fill(String uEmail, String aCode, String phNumber) {
        type(uEmail, userEmail);
        type(aCode, areaCode);
        type(phNumber, phoneNumber);
    }
}