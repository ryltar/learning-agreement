package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.spinneret.Spinneret;

import javax.persistence.*;
import java.util.List;

@Entity
@DiscriminatorValue("STUDENT")
public class Student extends User {

    @ManyToMany(cascade = { CascadeType.ALL })
    private List<Spinneret> spinnerets;
}
