package Flipkart.excpetions;

/**
 * Created by dakshay on 22/10/2021.
 */
public class CustomException extends RuntimeException{
    private Integer errorCode;
    private String errorMessage;

    public CustomException() {
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

    public CustomException(Integer errorCode, String errorMessage){
        super(errorMessage);
        this.errorCode=errorCode;
        this.errorMessage = errorMessage;
    }
    public CustomException(Integer errorCode){
        this.errorCode=errorCode;
    }
    public CustomException(String errorMessage){
        this.errorMessage=errorMessage;
    }
}
