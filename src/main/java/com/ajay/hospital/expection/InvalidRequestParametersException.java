package com.ajay.hospital.expection;

import java.util.List;

public class InvalidRequestParametersException extends RuntimeException {

    private List<String> i18nExceptionMessageKeys;

    public InvalidRequestParametersException(List<String> i18nExceptionMessageKeys) {
        this.i18nExceptionMessageKeys = i18nExceptionMessageKeys;
    }

    public List<String> getI18nExceptionMessageKeys() {
        return i18nExceptionMessageKeys;
    }

    public void setI18nExceptionMessageKeys(List<String> i18nExceptionMessageKeys) {
        this.i18nExceptionMessageKeys = i18nExceptionMessageKeys;
    }


}
