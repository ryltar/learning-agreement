package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import com.fges.rizomm.m1iii.learningagreementAPI.util.RoleEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("RPI")
public class Rpi extends User {
    @OneToMany(mappedBy="rpi")
    private List<Student> studentList;

    public Rpi(String username, String password, String firstname, String lastname, Collection<RoleEnum> roles) {
        super(username,password,firstname,lastname,roles);
    }

}
