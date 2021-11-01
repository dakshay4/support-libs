package com.dakshay.Exception;

/**
 * Created by stpl on 20/9/18.
 */
public class DException extends Exception{
    private Integer errorCode;
    private String errorMessage;

    public DException() {
        super();
    }
    public Integer getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public DException(Integer errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode=errorCode;
        this.errorMessage = errorMessage;
    }
    public DException(Integer errorCode){
        this.errorCode=errorCode;
    }
    public DException(String errorMessage){
        this.errorMessage=errorMessage;
    }

}
