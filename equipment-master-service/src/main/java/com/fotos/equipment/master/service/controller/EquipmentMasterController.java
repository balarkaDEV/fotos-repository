package com.fotos.equipment.master.service.controller;

import com.fotos.equipment.master.service.business.EquipmentMasterBusiness;
import com.fotos.equipment.master.service.exception.EquipmentMasterBusinessException;
import com.fotos.equipment.master.service.model.EquipmentMaster;
import com.fotos.equipment.master.service.util.EquipmentMasterValidator;
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
        return new ResponseEntity<List<EquipmentMaster>>(equipmentMasterBusiness.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentMaster> getItemById(@PathVariable long id){
        LOGGER.info("getItemById started");
        return new ResponseEntity<EquipmentMaster>(equipmentMasterBusiness.findById(id), HttpStatus.OK);
    }

    @GetMapping(value="/photographer",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EquipmentMaster>> getItemByPhotoGId(@RequestParam long photogId){
        LOGGER.info("getItemByPhotoGId started");
        return new ResponseEntity<List<EquipmentMaster>>(equipmentMasterBusiness.findByPhotographerId(photogId), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<EquipmentMaster> saveItem(@RequestBody final EquipmentMaster equipmentMaster){
        LOGGER.info("saveItem started");
        return new ResponseEntity<EquipmentMaster>(equipmentMasterBusiness.save(equipmentMaster), HttpStatus.OK);
    }
}
