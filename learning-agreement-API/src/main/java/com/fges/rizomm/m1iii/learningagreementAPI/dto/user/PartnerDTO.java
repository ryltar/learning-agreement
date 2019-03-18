package com.fges.rizomm.m1iii.learningagreementAPI.dto.user;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.dto.host_establishment.HostEstablishmentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PartnerDTO extends UserDTO {
    private FormDTO formDTO;
    private HostEstablishmentDTO hostEstablishmentDTO;

}
