package com.fotos.equipment.master.service.util;

import com.fotos.equipment.master.service.exception.EquipmentMasterBusinessException;
import com.fotos.equipment.master.service.model.EquipmentMaster;

public class EquipmentMasterValidator {
    public static void isValidRequest(EquipmentMaster equipmentMaster){
        if(equipmentMaster.getPhotographerId() == 0)
            throw new EquipmentMasterBusinessException("PhotographerID must be in request");
    }
}
