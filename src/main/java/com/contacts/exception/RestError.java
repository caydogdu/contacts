package com.contacts.exception;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author caydogdu
 *
 *         This is a error model for rest response
 */
@JsonInclude(Include.NON_NULL)
public class RestError {

    private String errorCode;

    private String errorDescription;

    private String developerMessage;

    public RestError(String errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorDescription(String errorDescription) {
        this.errorDescription = errorDescription;
    }

}
