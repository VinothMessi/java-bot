package com.generic.javabot.visaregistrationpages;

import com.generic.javabot.base.BasePage;
import org.openqa.selenium.By;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public
class VisaConfirmationPage extends BasePage {
    By panel = By.id("panel");
    By requestNumber = By.id("requestnumber");

    @Override
    public
    boolean hasItLoaded() {
        await()
                .atMost(10, TimeUnit.SECONDS)
                .pollInterval(1, TimeUnit.SECONDS)
                .until(() -> isVisible(requestNumber));
        return isClickable(requestNumber);
    }

    public
    String getMessage() {
        return getTextFrom(panel);
    }
}