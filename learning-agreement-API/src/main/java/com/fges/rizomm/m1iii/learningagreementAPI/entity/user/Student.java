package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@DiscriminatorValue("STUDENT")
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {

    @ManyToOne
    private Rpi rpi;

}
