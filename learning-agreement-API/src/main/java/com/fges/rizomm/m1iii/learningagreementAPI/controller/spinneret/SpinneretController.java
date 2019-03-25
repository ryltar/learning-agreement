package com.fges.rizomm.m1iii.learningagreementAPI.controller.spinneret;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.spinneret.SpinneretDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.services.spinneret.ISpinneretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/spinneret")
public class SpinneretController {

    @Autowired
    ISpinneretService spinneretService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<SpinneretDTO> findAllSpinnerets() {
        return this.spinneretService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SpinneretDTO findOneCourse(@PathVariable Long id) {
        return this.spinneretService.findOne(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public SpinneretDTO addCourse(@RequestBody SpinneretDTO courseDTO) {
        return this.spinneretService.addSpinneret(courseDTO);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public SpinneretDTO editCourse(@RequestBody SpinneretDTO courseDTO, @PathVariable Long id) {
        return this.spinneretService.editSpinneret(courseDTO, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCourse(@PathVariable Long id) {
        this.spinneretService.deleteSpinneret(id);
    }
}
