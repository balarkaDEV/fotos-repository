package com.fotos.orchestrator.service.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class OrchestratorEntity implements Serializable {
    private List<EquipmentMaster> equipmentMasters;
    private PhotographerMaster photographerMaster;
}
