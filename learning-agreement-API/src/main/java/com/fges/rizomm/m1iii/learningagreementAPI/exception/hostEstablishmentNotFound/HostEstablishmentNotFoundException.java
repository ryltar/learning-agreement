package com.fges.rizomm.m1iii.learningagreementAPI.exception.hostEstablishmentNotFound;

public class HostEstablishmentNotFoundException extends RuntimeException {

    public HostEstablishmentNotFoundException(Long id) {
        super("Could not find host establishment " + id);
    }

}
