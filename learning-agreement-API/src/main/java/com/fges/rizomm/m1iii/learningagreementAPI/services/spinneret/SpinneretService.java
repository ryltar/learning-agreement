package com.fges.rizomm.m1iii.learningagreementAPI.services.spinneret;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.spinneret.SpinneretDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.spinneret.Spinneret;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;

public class SpinneretService extends SuperService<Spinneret, SpinneretDTO> implements ISpinneretService {

    public SpinneretDTO entityToDto(Spinneret entity) {
        return super.getMapper().map(entity, SpinneretDTO.class);
    }

    public Spinneret dtoToEntity(SpinneretDTO dto) {
        return super.getMapper().map(dto, Spinneret.class);
    }
}
