package com.fges.rizomm.m1iii.learningagreementAPI.exception.hostEstablishmentNotFound;

import org.json.simple.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class HostEstablishmentNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(HostEstablishmentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    JSONObject hostEstablishmentNotFoundHandler(HostEstablishmentNotFoundException ex) {
        JSONObject response = new JSONObject();
        response.put("message", ex.getMessage());
        return response;
    }
}