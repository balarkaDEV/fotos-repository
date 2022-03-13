package com.demo.demoshiftservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/demo/shift")
public class DemoShiftController {

    @GetMapping
    public String getDefaultMsg(){
        return "This is demo default message";
    }

    @GetMapping(value="/{msg}")
    public String getParamMsg(@PathVariable String msg){
        return "This is demo param message with " + msg;
    }
}
