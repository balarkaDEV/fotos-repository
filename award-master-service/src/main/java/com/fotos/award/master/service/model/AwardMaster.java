package com.fotos.award.master.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "award_master")
public class AwardMaster implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private long id;

    @Column(name="name")
    private String name;

    @Column(name="type")
    private String type;

    @Column(name="year")
    private int year;

    @Column(name="country")
    private String country;

    @Column(name="organization")
    private String organization;

    @Column(name="entry_date")
    private Date entryDate;

    @Column(name="photographer_id")
    private long photographerId;
}
