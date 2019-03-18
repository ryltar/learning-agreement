package com.fges.rizomm.m1iii.learningagreementAPI.dto.form;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.host_establishment.HostEstablishmentDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.course.Course;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Partner;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Rpi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FormDTO {
    private int schoolYearStart;
    private int schoolYearEnd;
    private short semester;
    private Date signatureDate;
    private Rpi rpi;
    private Partner partner;
    private List<Course> courses;
    private HostEstablishmentDTO hostEstablishmentDTO;

}
