package com.fges.rizomm.m1iii.learningagreementAPI.services.spinneret;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.spinneret.SpinneretDTO;

import java.util.List;

public interface ISpinneretService {

    SpinneretDTO addSpinneret(SpinneretDTO spinneretDTO);
    List<SpinneretDTO> findAll();
    SpinneretDTO editSpinneret(SpinneretDTO spinneretDTO, Long id);
    void deleteSpinneret(Long id);
    SpinneretDTO findOne(Long id);
}
