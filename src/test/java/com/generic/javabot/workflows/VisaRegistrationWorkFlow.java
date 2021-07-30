package com.generic.javabot.workflows;

import com.generic.javabot.visaregistrationpages.HomePage;
import com.generic.javabot.visaregistrationpages.VisaConfirmationPage;
import com.generic.javabot.visaregistrationpages.VisaFormPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class VisaRegistrationWorkFlow {
    @Autowired
    protected HomePage homePage;

    @Autowired
    protected VisaFormPage visaPage;

    @Autowired
    protected VisaConfirmationPage visaConfirmation;

    public
    VisaRegistrationWorkFlow inTheBrowser(Consumer<HomePage> c) {
        c.accept(homePage);
        return this;
    }

    public
    VisaRegistrationWorkFlow form(Consumer<VisaFormPage> c) {
        c.accept(visaPage);
        return this;
    }

    public
    VisaRegistrationWorkFlow confirmation(Consumer<VisaConfirmationPage> c) {
        c.accept(visaConfirmation);
        return this;
    }
}