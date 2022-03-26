package com.fotos.edge.service.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FotosEdgeController {

    @GetMapping(value="/photographer-fallback")
    public void processPhotoGFallback(){
    }
}
