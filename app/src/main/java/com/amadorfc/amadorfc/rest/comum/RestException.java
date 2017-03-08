package com.amadorfc.amadorfc.rest.comum;

/**
 * Created by vinic on 16/02/2016.
 */
public class RestException extends RuntimeException {

    public RestException(String detailMessage) {
        super(detailMessage);
    }

    public RestException(String detailMessage, Throwable throwable) {
        super(detailMessage, throwable);
    }

    public RestException(Integer errCode, String detailMessage) {
        super(detailMessage);
        this.errCode = errCode;
        this.errMessage = detailMessage;
    }

    private String errMessage;
    private Integer errCode;

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    public String getErrMessage() {
        return errMessage;
    }

    public Integer getErrCode() {
        return errCode;
    }
}
