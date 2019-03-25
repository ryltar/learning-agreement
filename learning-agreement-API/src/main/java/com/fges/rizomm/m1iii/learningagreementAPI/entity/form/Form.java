package com.fges.rizomm.m1iii.learningagreementAPI.entity.form;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.LearningEntity;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.course.Course;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.host_establishment.HostEstablishment;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Partner;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Rpi;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

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
    @OneToMany(mappedBy="form")
    private List<Course> courses;
    @ManyToOne
    private HostEstablishment hostEstablishment;
    @ManyToOne
    private Student student;
    @CreatedDate
    private Date createdAt;
    private Date lastModified;
    @Column(nullable = false, columnDefinition = "boolean default false")
    private boolean isClosed;
}
