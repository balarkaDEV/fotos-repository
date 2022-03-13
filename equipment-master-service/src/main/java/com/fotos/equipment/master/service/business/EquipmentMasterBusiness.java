package com.fotos.equipment.master.service.business;

import com.fotos.equipment.master.service.model.EquipmentMaster;
import com.fotos.equipment.master.service.repository.EquipmentMasterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipmentMasterBusiness {
    @Autowired
    private EquipmentMasterRepository equipmentMasterRepository;

    public List<EquipmentMaster> findAll(){
        return equipmentMasterRepository.findAll();
    }

    public Optional<EquipmentMaster> findById(long id){
        return equipmentMasterRepository.findById(id);
    }

    public List<EquipmentMaster> findByPhotographerId(long photogId){
        return equipmentMasterRepository.findByPhotographerId(photogId);
    }

    public EquipmentMaster save(EquipmentMaster equipmentMaster){
        return equipmentMasterRepository.save(equipmentMaster);
    }
}
