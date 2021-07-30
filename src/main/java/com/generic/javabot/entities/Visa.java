package com.generic.javabot.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Proxy;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Proxy(lazy = false)
public
class Visa {
    @Id
    private Integer id;

    private String firstName;
    private String middleName;
    private String lastName;

    private String fromCountry;
    private String toCountry;

    private String month;
    private String day;
    private String year;

    private String mail;
    private String code;
    private String number;
}