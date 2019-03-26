package com.fges.rizomm.m1iii.learningagreementAPI.dto.user;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Rpi;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDTO extends UserDTO {

    private Rpi rpi;

}
