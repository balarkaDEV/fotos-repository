package com.fotos.orchestrator.service.controller;

import com.fotos.orchestrator.service.business.OrchestratorBusiness;
import com.fotos.orchestrator.service.model.OrchestratorEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="${root.service.moduleurl}")
public class OrchestratorController {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrchestratorController.class);

    @Autowired
    private OrchestratorBusiness orchestratorBusiness;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<OrchestratorEntity> save(@RequestBody final OrchestratorEntity orchestratorEntity){
        LOGGER.info("saveItem started");
        return new ResponseEntity<OrchestratorEntity>(orchestratorBusiness.save(orchestratorEntity), HttpStatus.OK);
    }
}
