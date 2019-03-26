package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;


@Entity
@Getter
@Setter
@DiscriminatorValue("STUDENT")
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {

    @ManyToOne
    private Rpi rpi;

    public Student(String username, String password, String firstname, String lastname, Collection<RoleEnum> roles) {
        super(username,password,firstname,lastname,roles);
    }

}
