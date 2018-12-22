package com.fges.rizomm.m1iii.learningagreementAPI.entity.form;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.LearningEntity;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Partner;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Rpi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Form")
public class Form extends LearningEntity<Long> implements Serializable {
    private int schoolYearStart;
    private int schoolYearEnd;
    private short semester;
    private Date signatureDate;
    @OneToOne(cascade = CascadeType.ALL)
    private Rpi rpi;
    @OneToOne(cascade = CascadeType.ALL)
    private Partner partner;
}
