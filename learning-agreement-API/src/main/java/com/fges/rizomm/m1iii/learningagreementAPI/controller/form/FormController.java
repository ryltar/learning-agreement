package com.fges.rizomm.m1iii.learningagreementAPI.controller.form;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.form.FormDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.services.form.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/form")
public class FormController {

    @Autowired
    IFormService formService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<FormDTO> findAllForms() {
        return this.formService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FormDTO findOneForm(@PathVariable Long id) {
        return this.formService.findOne(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public FormDTO addForm(@RequestBody FormDTO courseDTO) {
        return this.formService.addForm(courseDTO);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public FormDTO editForm(@RequestBody FormDTO courseDTO, @PathVariable Long id) {
        return this.formService.editForm(courseDTO, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteForm(@PathVariable Long id) {
        this.formService.deleteForm(id);
    }
}
