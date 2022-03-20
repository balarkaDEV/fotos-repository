package com.fotos.orchestrator.service.exception;

public class OrchestratorBusinessException extends RuntimeException {

    private String errorCode;
    private String errorMessage;

    public OrchestratorBusinessException(String errorMessage) {
        super();
        this.errorMessage = errorMessage;
    }

    public OrchestratorBusinessException(String errorCode, String errorMessage) {
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
