package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.spinneret.Spinneret;
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
@DiscriminatorValue("STUDENT")
@NoArgsConstructor
@AllArgsConstructor
public class Student extends User {

    @ManyToMany(cascade = { CascadeType.ALL })
    private List<Spinneret> spinnerets;

    public Student(String username, String firstname, String lastname, Collection<RoleEnum> roles) {

    }
}
