package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@DiscriminatorValue("RPI")
public class Rpi extends User {
    @OneToMany(mappedBy="rpi")
    private List<Student> studentList;
}
