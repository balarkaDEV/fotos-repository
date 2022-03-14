package com.fotos.equipment.master.service.advice;

import com.fotos.equipment.master.service.exception.EquipmentMasterBusinessException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EquipmentMasterAdvice {
    private static final Logger LOGGER = LoggerFactory.getLogger(EquipmentMasterAdvice.class);

    @ExceptionHandler(EquipmentMasterBusinessException.class)
    public ResponseEntity<String> handleBusinessException(EquipmentMasterBusinessException exception){
        if(exception.getErrorMessage() != null)
            return new ResponseEntity<String>(exception.getErrorMessage(), HttpStatus.NOT_FOUND);
        else
            return new ResponseEntity<String>("Record not found", HttpStatus.NOT_FOUND);

    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception exception){
        LOGGER.error("Exception occurred:" + exception.getMessage());
        exception.printStackTrace();
        return new ResponseEntity<String>("A generic exception occurred", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
