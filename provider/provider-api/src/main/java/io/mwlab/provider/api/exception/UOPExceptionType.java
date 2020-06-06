package io.mwlab.provider.api.exception;

public enum UOPExceptionType {

    PROVIDER_PAYPAL(1, "Code %d - PayPal Exception: %s");

    private final int code;
    private final String messageFormat;

    UOPExceptionType(int code, String messageFormat){
        this.code = code;
        this.messageFormat = messageFormat;
    }

    public int getCode() {
        return code;
    }

    public String getMessageFormat() {
        return messageFormat;
    }
}
