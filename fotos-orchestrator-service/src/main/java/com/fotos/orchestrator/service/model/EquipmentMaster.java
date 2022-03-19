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
public class EquipmentMaster implements Serializable {
    private long id;
    private String name;
    private String type;
    private String make;
    private Date entryDate;
    private long photographerId;
}
