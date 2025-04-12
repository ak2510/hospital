package com.ajay.hospital.expection;

import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class APIResponse {

    public void renderJsonResponse(HttpStatus status, Object body) {

        HttpEnum httpEnum = HttpEnum.valueOf(status.name());
        Map<String, Serializable> response  = Map.of("status", httpEnum.jsendDesc(), "code", status.value());

        Map<String, String> responseBody = (body instanceof String) ? Map.of("message", body.toString()) : (Map)body;

        response.putAll(responseBody);

    }
}
