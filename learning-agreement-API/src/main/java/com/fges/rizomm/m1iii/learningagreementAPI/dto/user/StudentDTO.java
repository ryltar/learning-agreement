package com.fges.rizomm.m1iii.learningagreementAPI.dto.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.spinneret.SpinneretDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.spinneret.Spinneret;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
public class StudentDTO extends UserDTO {
    private List<SpinneretDTO> spinneretsDTO;

}
