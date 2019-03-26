package com.fges.rizomm.m1iii.learningagreementAPI.dto.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Rpi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RpiDTO extends UserDTO {
    private List<FormDTO> formDTOList;

}
