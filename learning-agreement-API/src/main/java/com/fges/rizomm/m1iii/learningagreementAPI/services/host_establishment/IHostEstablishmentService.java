package com.fges.rizomm.m1iii.learningagreementAPI.services.host_establishment;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.host_establishment.HostEstablishmentDTO;

import java.util.List;

public interface IHostEstablishmentService {

    HostEstablishmentDTO addHostEstablishment(HostEstablishmentDTO spinneretDTO);
    List<HostEstablishmentDTO> findAll();
    HostEstablishmentDTO editHostEstablishment(HostEstablishmentDTO spinneretDTO, Long id);
    void deleteHostEstablishment(Long id);
    HostEstablishmentDTO findOne(Long id);

}
