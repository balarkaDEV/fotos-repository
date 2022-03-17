package com.fotos.equipment.master.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EquipmentMasterRequest implements Serializable {
    private EquipmentMaster equipmentMaster;
    private PhotographerMaster photographerMaster;
}
