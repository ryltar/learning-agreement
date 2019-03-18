package com.fges.rizomm.m1iii.learningagreementAPI.services.form;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.form.Form;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;

public class FormService extends SuperService<Form, FormDTO> implements IFormService {

    public FormDTO entityToDto(Form entity) {
        return super.getMapper().map(entity, FormDTO.class);
    }

    public Form dtoToEntity(FormDTO dto) {
        return super.getMapper().map(dto, Form.class);
    }
}
