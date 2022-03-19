package com.fotos.orchestrator.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrchestratorEntity implements Serializable {
    private EquipmentMaster equipmentMaster;
    private PhotographerMaster photographerMaster;
}
