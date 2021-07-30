package com.generic.javabot.visaregistrationpages;

import com.generic.javabot.base.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class UserDetails extends BasePage {
    By firstName = By.id("first_4");
    By middleName = By.id("middle_4");
    By lastName = By.id("last_4");

    @Override
    public
    boolean hasItLoaded() {
        return isVisible(firstName) && isClickable(firstName);
    }

    void fill(String fName, String mName, String lName) {
        type(fName, firstName);
        type(mName, middleName);
        type(lName, lastName);
    }
}