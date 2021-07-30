package com.generic.javabot.visaregistrationpages;

import com.generic.javabot.base.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class VisaFormPage extends BasePage {
    By header = By.id("header_1");
    By subHeader = By.id("subHeader_1");

    By comments = By.id("input_45");
    By submit = By.id("submitBtn");

    @Autowired
    private UserDetails userDetails;

    @Autowired
    private CountryDetails countryDetails;

    @Autowired
    private BirthDetails birthDetails;

    @Autowired
    private ContactDetails contactDetails;

    @Override
    public
    boolean hasItLoaded() {
        return isVisible(header) && isClickable(subHeader);
    }

    public
    String getHeader() {
        return getTextFrom(header).trim();
    }

    public
    String getSubHeader() {
        return getTextFrom(subHeader).trim();
    }

    public
    void fillForm(String fName, String mName, String lName, String fCountry,
                  String tCountry, String mOnth, String dAy, String yEar,
                  String uEmail, String aCode, String phNumber, String comment) {
        try {
            userDetails.hasItLoaded();
            userDetails.fill(fName, mName, lName);
            countryDetails.hasItLoaded();
            countryDetails.fill(fCountry, tCountry);
            birthDetails.hasItLoaded();
            birthDetails.fill(mOnth, dAy, yEar);
            contactDetails.hasItLoaded();
            contactDetails.fill(uEmail, aCode, phNumber);
            type(comment, comments);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public
    void submitForm() {
        clickOn(submit);
    }
}