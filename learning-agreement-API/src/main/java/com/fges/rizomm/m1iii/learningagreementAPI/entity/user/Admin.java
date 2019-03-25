package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@Getter
@Setter
@DiscriminatorValue("ADMIN")
public class Admin extends User {

}