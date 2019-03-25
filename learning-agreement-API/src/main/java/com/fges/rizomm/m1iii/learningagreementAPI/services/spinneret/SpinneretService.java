package com.fges.rizomm.m1iii.learningagreementAPI.services.spinneret;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.spinneret.SpinneretDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.spinneret.Spinneret;
import com.fges.rizomm.m1iii.learningagreementAPI.exception.spinneretNotFound.SpinneretNotFoundException;
import com.fges.rizomm.m1iii.learningagreementAPI.repository.spinneret.SpinneretRepository;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SpinneretService extends SuperService<Spinneret, SpinneretDTO> implements ISpinneretService {

    private final SpinneretRepository spinneretRepository;

    @Autowired
    public SpinneretService(SpinneretRepository spinneretRepository) {
        this.spinneretRepository = spinneretRepository;
    }

    @Override
    public SpinneretDTO entityToDto(Spinneret entity) {
        return super.getMapper().map(entity, SpinneretDTO.class);
    }

    @Override
    public Spinneret dtoToEntity(SpinneretDTO dto) {
        return super.getMapper().map(dto, Spinneret.class);
    }

    @Override
    public SpinneretDTO addSpinneret(SpinneretDTO courseDTO) {
        return this.entityToDto(this.spinneretRepository.save(this.dtoToEntity(courseDTO)));
    }

    @Override
    public List<SpinneretDTO> findAll() {
        return this.entityListToDtoList(this.spinneretRepository.findAll());
    }

    @Override
    public SpinneretDTO findOne(Long id) {
        return this.entityToDto(this.spinneretRepository.findById(id).orElseThrow(() -> new SpinneretNotFoundException(id)));
    }

    @Override
    public SpinneretDTO editSpinneret(SpinneretDTO spinneretDTO, Long id) {
        return this.spinneretRepository.findById(id).map(course -> {
            spinneretDTO.setId(id);
            return this.entityToDto(this.spinneretRepository.save(this.dtoToEntity(spinneretDTO)));
        }).orElseThrow(() -> new SpinneretNotFoundException(id));

    }

    @Override
    public void deleteSpinneret(Long id) {
        Spinneret spinneretToDelete = this.spinneretRepository.findById(id).orElseThrow(() -> new SpinneretNotFoundException(id));
        this.spinneretRepository.delete(spinneretToDelete);
    }

}
