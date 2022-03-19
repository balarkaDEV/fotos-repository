package com.fotos.orchestrator.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PhotographerMaster implements Serializable {
    private long id;
    private String name;
    private String type;
    private String status;
    private int startYear;
    private String addressLine1;
    private String addressLine2;
    private String city;
    private String state;
    private String pinCode;
    private String country;
    private String phoneNo1;
    private String phoneNo2;
    private String website;
    private String email;
    private String companyName;
    private String registered;
    private Date registrationDate;
    private Date memberSince;
    private String stateMobility;
    private String internationalMobility;
    private String video;
    private String photo;
}
