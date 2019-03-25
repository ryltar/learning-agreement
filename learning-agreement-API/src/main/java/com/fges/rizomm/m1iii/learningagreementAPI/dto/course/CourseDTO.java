package com.fges.rizomm.m1iii.learningagreementAPI.dto.course;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CourseDTO {
    private Long id;
    private String titleCourse;
    private int nbrCredits;
    private int nbrEcts;
    private FormDTO formDTO;

}
