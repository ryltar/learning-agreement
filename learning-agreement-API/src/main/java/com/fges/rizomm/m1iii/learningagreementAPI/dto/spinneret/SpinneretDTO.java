package com.fges.rizomm.m1iii.learningagreementAPI.dto.spinneret;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.StudentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SpinneretDTO {

    private String level;
    private String label;
    private List<StudentDTO> students;

}
