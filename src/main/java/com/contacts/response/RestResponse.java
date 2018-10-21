package com.contacts.response;

import com.contacts.exception.RestError;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

/**
 *
 * @author caydogdu
 *
 *         This is a coomon response class for rest response
 * @param <T>
 */
@JsonInclude(value = Include.NON_NULL)
public class RestResponse<T> {

    private boolean success;

    private T result;

    private RestError error;

    private Object resultInfo;

    public RestError getError() {
        return error;
    }

    public T getResult() {
        return result;
    }

    public Object getResultInfo() {
        return resultInfo;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setError(RestError error) {
        this.error = error;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public void setResultInfo(Object resultInfo) {
        this.resultInfo = resultInfo;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}