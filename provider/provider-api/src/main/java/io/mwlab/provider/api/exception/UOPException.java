package io.mwlab.provider.api.exception;

public class UOPException extends RuntimeException {

    private final int errorCode;



    public UOPException(UOPExceptionType type, Throwable e){
        super(String.format(type.getMessageFormat(), type.getCode(), e.getMessage()));
        errorCode = type.getCode();
    }



}
