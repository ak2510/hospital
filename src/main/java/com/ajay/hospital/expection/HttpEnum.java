package com.ajay.hospital.expection;

public enum HttpEnum {
    OK("success"),
    NO_CONTENT("success"),
    CREATED("success"),
    BAD_REQUEST("fail"),
    NOT_FOUND("fail"),
    UNAUTHORIZED("fail"),
    FORBIDDEN("fail"),
    CONFLICT("fail"),
    LOCKED("fail"),
    TEMPORARY_REDIRECT("fail"),
    INTERNAL_SERVER_ERROR("error"),
    NOT_IMPLEMENTED("error"),
    BAD_GATEWAY("error"),
    SERVICE_UNAVAILABLE("error"),
    GATEWAY_TIMEOUT("error");

    private String jsendDesc;

    HttpEnum(String desc) {
        this.jsendDesc = desc;
    }

    public String jsendDesc() {
        return jsendDesc;
    }
}
