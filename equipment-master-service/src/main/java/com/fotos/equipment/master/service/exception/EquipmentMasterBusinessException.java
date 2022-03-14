package com.fotos.equipment.master.service.exception;

public class EquipmentMasterBusinessException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public EquipmentMasterBusinessException(){
        super();
    }

    public EquipmentMasterBusinessException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public EquipmentMasterBusinessException (String errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
    public String getErrorMessage() {
        return errorMessage;
    }
    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
