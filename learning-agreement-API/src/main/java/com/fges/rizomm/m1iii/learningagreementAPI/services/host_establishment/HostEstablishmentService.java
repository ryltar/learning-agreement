package com.fges.rizomm.m1iii.learningagreementAPI.services.host_establishment;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.host_establishment.HostEstablishmentDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.host_establishment.HostEstablishment;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;

public class HostEstablishmentService extends SuperService<HostEstablishment, HostEstablishmentDTO> implements IHostEstablishmentService {

    public HostEstablishmentDTO entityToDto(HostEstablishment entity) {
        return super.getMapper().map(entity, HostEstablishmentDTO.class);
    }

    public HostEstablishment dtoToEntity(HostEstablishmentDTO dto) {
        return super.getMapper().map(dto, HostEstablishment.class);
    }

}
