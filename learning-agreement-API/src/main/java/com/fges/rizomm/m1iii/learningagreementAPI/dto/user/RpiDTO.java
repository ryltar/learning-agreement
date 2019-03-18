package com.fges.rizomm.m1iii.learningagreementAPI.dto.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Rpi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RpiDTO extends UserDTO {
    private FormDTO formDTO;

}
