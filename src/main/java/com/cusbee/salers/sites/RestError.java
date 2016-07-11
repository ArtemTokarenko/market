package com.cusbee.salers.sites;

public class RestError {
    private int appErrorCode;
    private String appErrorMessage;

    public RestError(int appErrorCode, String appErrorMessage) {
        super();
        this.appErrorCode = appErrorCode;
        this.appErrorMessage = appErrorMessage;
    }

    public int getAppErrorCode() {
        return appErrorCode;
    }

    public void setAppErrorCode(int appErrorCode) {
        this.appErrorCode = appErrorCode;
    }

    public String getAppErrorMessage() {
        return appErrorMessage;
    }

    public void setAppErrorMessage(String appErrorMessage) {
        this.appErrorMessage = appErrorMessage;
    }

}