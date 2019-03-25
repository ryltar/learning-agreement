package com.fges.rizomm.m1iii.learningagreementAPI.services.host_establishment;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.host_establishment.HostEstablishmentDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.host_establishment.HostEstablishment;
import com.fges.rizomm.m1iii.learningagreementAPI.exception.hostEstablishmentNotFound.HostEstablishmentNotFoundException;
import com.fges.rizomm.m1iii.learningagreementAPI.repository.host_establishment.HostEstablishmentRepository;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class HostEstablishmentService extends SuperService<HostEstablishment, HostEstablishmentDTO> implements IHostEstablishmentService {

    @Override
    public HostEstablishmentDTO entityToDto(HostEstablishment entity) {
        return super.getMapper().map(entity, HostEstablishmentDTO.class);
    }

    @Override
    public HostEstablishment dtoToEntity(HostEstablishmentDTO dto) {
        return super.getMapper().map(dto, HostEstablishment.class);
    }

    private final HostEstablishmentRepository hostEstablishmentRepository;

    @Autowired
    public HostEstablishmentService(HostEstablishmentRepository hostEstablishmentRepository) {
        this.hostEstablishmentRepository = hostEstablishmentRepository;
    }

    @Override
    public HostEstablishmentDTO addHostEstablishment(HostEstablishmentDTO courseDTO) {
        return this.entityToDto(this.hostEstablishmentRepository.save(this.dtoToEntity(courseDTO)));
    }

    @Override
    public List<HostEstablishmentDTO> findAll() {
        return this.entityListToDtoList(this.hostEstablishmentRepository.findAll());
    }

    @Override
    public HostEstablishmentDTO findOne(Long id) {
        return this.entityToDto(this.hostEstablishmentRepository.findById(id).orElseThrow(() -> new HostEstablishmentNotFoundException(id)));
    }

    @Override
    public HostEstablishmentDTO editHostEstablishment(HostEstablishmentDTO hostEstablishmentDTO, Long id) {
        return this.hostEstablishmentRepository.findById(id).map(course -> {
            hostEstablishmentDTO.setId(id);
            return this.entityToDto(this.hostEstablishmentRepository.save(this.dtoToEntity(hostEstablishmentDTO)));
        }).orElseThrow(() -> new HostEstablishmentNotFoundException(id));

    }

    public void deleteHostEstablishment(Long id) {
        HostEstablishment hostEstablishmentToDelete = this.hostEstablishmentRepository.findById(id).orElseThrow(() -> new HostEstablishmentNotFoundException(id));
        this.hostEstablishmentRepository.delete(hostEstablishmentToDelete);
    }

}
