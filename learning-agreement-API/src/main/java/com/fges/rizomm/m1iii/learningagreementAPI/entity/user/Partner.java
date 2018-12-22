package com.fges.rizomm.m1iii.learningagreementAPI.entity.user;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.form.Form;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.host_establishment.HostEstablishment;

import javax.persistence.*;

@Entity
@DiscriminatorValue("PARTNER")
public class Partner extends User {
    @OneToOne(cascade = CascadeType.ALL)
    private Form form;
    @ManyToOne
    private HostEstablishment hostEstablishment;
}
