package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.form.Form;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@DiscriminatorValue("RPI")
public class Rpi extends User {
    @OneToOne(cascade = CascadeType.ALL)
    private Form form;
}
