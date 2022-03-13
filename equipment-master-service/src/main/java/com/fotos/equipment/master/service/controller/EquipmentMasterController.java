package com.fotos.equipment.master.service.controller;

import com.fotos.equipment.master.service.business.EquipmentMasterBusiness;
import com.fotos.equipment.master.service.exception.EquipmentMasterBusinessException;
import com.fotos.equipment.master.service.model.EquipmentMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value="${root.service.moduleurl}")
public class EquipmentMasterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EquipmentMasterController.class);

    @Autowired
    private EquipmentMasterBusiness equipmentMasterBusiness;

    @GetMapping(value="/", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EquipmentMaster>> getAllItem(){
        LOGGER.info("getAllItem started");
        List<EquipmentMaster> list = equipmentMasterBusiness.findAll();

        if (list.size() == 0)
            throw new EquipmentMasterBusinessException("No Records Found");

        LOGGER.info("getAllItem ended");
        return new ResponseEntity<List<EquipmentMaster>>(list, HttpStatus.OK);
    }

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<EquipmentMaster> getItemById(@PathVariable long id){
        LOGGER.info("getItemById started");
        return equipmentMasterBusiness.findById(id);
    }

    @GetMapping(value="/photographer",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EquipmentMaster>> getItemByPhotoGId(@RequestParam long photogId){
        LOGGER.info("getItemByPhotoGId started");
        List<EquipmentMaster> list = equipmentMasterBusiness.findByPhotographerId(photogId);

        if (list.size() == 0)
            throw new EquipmentMasterBusinessException("No Records Found");

        LOGGER.info("getItemByPhotoGId ended");
        return new ResponseEntity<List<EquipmentMaster>>(list, HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentMaster> saveItem(@RequestBody final EquipmentMaster equipmentMaster){
        LOGGER.info("saveItem started");
        EquipmentMaster response = equipmentMasterBusiness.save(equipmentMaster);
        LOGGER.info("saveItem ended");
        return new ResponseEntity<EquipmentMaster>(response, HttpStatus.OK);
    }
}
