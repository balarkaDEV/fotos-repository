package com.fotos.equipment.master.service.business;

import com.fotos.equipment.master.service.exception.EquipmentMasterBusinessException;
import com.fotos.equipment.master.service.model.EquipmentMaster;
import com.fotos.equipment.master.service.model.EquipmentMasterRequest;
import com.fotos.equipment.master.service.repository.EquipmentMasterRepository;
import com.fotos.equipment.master.service.util.EquipmentMasterValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class EquipmentMasterBusiness {

    @Autowired
    private EquipmentMasterRepository equipmentMasterRepository;

    public List<EquipmentMaster> findAll(){
        return Optional.of(equipmentMasterRepository.findAll()).orElseThrow(EquipmentMasterBusinessException::new);
    }

    public EquipmentMaster findById(long id){
        return equipmentMasterRepository.findById(id).orElseThrow(EquipmentMasterBusinessException::new);
    }

    public List<EquipmentMaster> findByPhotographerId(long photogId){
        return Optional.of(equipmentMasterRepository.findByPhotographerId(photogId)).orElseThrow(EquipmentMasterBusinessException::new);
    }

    public EquipmentMaster save(EquipmentMaster equipmentMaster){
        EquipmentMasterValidator.isValidRequest(equipmentMaster);
        equipmentMaster.setEntryDate(new Date());
        return equipmentMasterRepository.save(equipmentMaster);
    }

    /*public EquipmentMaster saveWithPhotographerInfo(EquipmentMasterRequest equipmentMasterRequest) {

        return new EquipmentMaster();
    }*/
}
