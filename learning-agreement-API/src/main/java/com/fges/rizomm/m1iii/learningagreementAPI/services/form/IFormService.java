package com.fges.rizomm.m1iii.learningagreementAPI.services.form;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;

import java.util.List;

public interface IFormService {

    FormDTO addForm(FormDTO courseDTO);
    List<FormDTO> findAll();
    FormDTO editForm(FormDTO courseDTO, Long id);
    void deleteForm(Long id);
    FormDTO findOne(Long id);
}
