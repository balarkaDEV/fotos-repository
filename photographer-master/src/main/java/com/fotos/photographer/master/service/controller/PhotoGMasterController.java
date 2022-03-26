package com.fotos.photographer.master.service.controller;

import com.fotos.photographer.master.service.business.PhotoGMasterBusiness;
import com.fotos.photographer.master.service.exception.PhotoGMasterBusinessException;
import com.fotos.photographer.master.service.model.PhotographerMaster;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping(value="${root.service.moduleurl}")
public class PhotoGMasterController {

    private static final Logger LOGGER = LoggerFactory.getLogger(PhotoGMasterController.class);

    @Autowired
    private PhotoGMasterBusiness photoGMasterBusiness;

    @GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhotographerMaster>> findAll(){
        LOGGER.info("getAllItem started");
        return new ResponseEntity<List<PhotographerMaster>>(photoGMasterBusiness.findAllRecords(), HttpStatus.OK);
    }

    @GetMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotographerMaster> findById(@PathVariable long id){
        LOGGER.info("getItemById started");
        return new ResponseEntity<PhotographerMaster>(photoGMasterBusiness.findRecordById(id), HttpStatus.OK);
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<PhotographerMaster>> findByQuery(@RequestParam Map<String, String> queryParams){
        LOGGER.info("findItemsByQuery started");
        return new ResponseEntity<List<PhotographerMaster>>(photoGMasterBusiness.findRecordsByQuery(queryParams), HttpStatus.OK);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotographerMaster> save(@RequestBody final PhotographerMaster photographerMaster){
        LOGGER.info("saveItem started");
        return new ResponseEntity<PhotographerMaster>(photoGMasterBusiness.save(photographerMaster), HttpStatus.OK);
    }

    @DeleteMapping(value="/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<PhotographerMaster> delete(@PathVariable long id){
        photoGMasterBusiness.deleteById(id);
        return new ResponseEntity<PhotographerMaster>(HttpStatus.OK);
    }
}
