package com.ajay.hospital.expection;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class NotFoundException extends RuntimeException{

    private String i18ExceptionMsgKey;

    public NotFoundException(String i18ExceptionMsgKey) {
        super(i18ExceptionMsgKey);
        this.i18ExceptionMsgKey = i18ExceptionMsgKey;
    }
}
