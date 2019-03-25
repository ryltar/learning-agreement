package com.fges.rizomm.m1iii.learningagreementAPI.services.form;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.form.Form;
import com.fges.rizomm.m1iii.learningagreementAPI.exception.formNotFound.FormNotFoundException;
import com.fges.rizomm.m1iii.learningagreementAPI.repository.form.FormRepository;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class FormService extends SuperService<Form, FormDTO> implements IFormService {

    private final FormRepository formRepository;

    @Autowired
    public FormService(FormRepository formRepository) {
        this.formRepository = formRepository;
    }

    public FormDTO entityToDto(Form entity) {
        return super.getMapper().map(entity, FormDTO.class);
    }

    public Form dtoToEntity(FormDTO dto) {
        return super.getMapper().map(dto, Form.class);
    }

    @Override
    public FormDTO addForm(FormDTO courseDTO) {
        return this.entityToDto(this.formRepository.save(this.dtoToEntity(courseDTO)));
    }

    @Override
    public List<FormDTO> findAll() {
        return this.entityListToDtoList(this.formRepository.findAll());
    }

    @Override
    public FormDTO findOne(Long id) {
        return this.entityToDto(this.formRepository.findById(id).orElseThrow(() -> new FormNotFoundException(id)));
    }

    @Override
    public FormDTO editForm(FormDTO courseDTO, Long id) {
        return this.formRepository.findById(id).map(course -> {
            courseDTO.setId(id);
            return this.entityToDto(this.formRepository.save(this.dtoToEntity(courseDTO)));
        }).orElseThrow(() -> new FormNotFoundException(id));

    }

    public void deleteForm(Long id) {
        Form formToDelete = this.formRepository.findById(id).orElseThrow(() -> new FormNotFoundException(id));
        this.formRepository.delete(formToDelete);
    }
}
