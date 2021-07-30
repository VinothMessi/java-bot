package com.generic.javabot.testcases;

import com.generic.javabot.BaseTest;
import com.generic.javabot.entities.Visa;
import com.generic.javabot.repositories.VisaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.stream.Collectors;

public
class VisaRegistration extends BaseTest {
    @Autowired
    private
    VisaRepository repository;

    @Test(dataProvider = "visa")
    public
    void visaRegistration(Visa data, Method m) {
        forVisaRegistration
                .inTheBrowser(p -> {
                    p.launch(project.getAppUrl());
                    Assert.assertTrue(p.hasItLoaded());
                    Assert.assertEquals(p.pageTitle(), project.getAppTitle());
                })
                .form(p -> {
                    Assert.assertTrue(p.hasItLoaded());
                    Assert.assertEquals(p.getHeader(), project.getHeader());
                    Assert.assertEquals(p.getSubHeader(), project.getSubHeader());
                    p.fillForm(data.getFirstName(), data.getMiddleName(), data.getLastName(),
                            data.getFromCountry(), data.getToCountry(), data.getMonth(), data.getDay(),
                            data.getYear(), data.getMail(), data.getCode(), data.getNumber(),
                            data.getFirstName() + " " + data.getLastName() + " " + "Visa Details");
                    p.submitForm();
                })
                .confirmation(p -> {
                    Assert.assertTrue(p.hasItLoaded());
                    System.out.println(p.getMessage());
                    snap.savePageAs(data.getFirstName() + data.getLastName());
                });
    }

    @DataProvider(name = "visa")
    public
    java.lang.Object[] getData() {
        return this.repository
                .findAll()
                .stream()
                .collect(Collectors.toList()).toArray();
    }
}