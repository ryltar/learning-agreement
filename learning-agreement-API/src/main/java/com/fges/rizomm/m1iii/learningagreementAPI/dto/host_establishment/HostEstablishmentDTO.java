package com.fges.rizomm.m1iii.learningagreementAPI.dto.host_establishment;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.user.PartnerDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HostEstablishmentDTO {
    private String name;
    private String country;
    private List<PartnerDTO> partners;
    private List<FormDTO> forms;
}
