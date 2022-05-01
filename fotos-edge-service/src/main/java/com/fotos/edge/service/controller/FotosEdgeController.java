package com.fotos.edge.service.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FotosEdgeController {

    @GetMapping(value="/photographer-fallback", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processPhotoGMasterFallback(){
        return new ResponseEntity<String>("Failed to get any response from photographer master", HttpStatus.OK);
    }

    @GetMapping(value="/equipment-fallback", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> processEqMasterFallback(){
        return new ResponseEntity<String>("Failed to get any response from equipment master", HttpStatus.OK);
    }
}
