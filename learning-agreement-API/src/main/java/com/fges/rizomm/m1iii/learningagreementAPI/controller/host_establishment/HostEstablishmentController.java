package com.fges.rizomm.m1iii.learningagreementAPI.controller.host_establishment;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.host_establishment.HostEstablishmentDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.services.host_establishment.IHostEstablishmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/hostEstablishment")
public class HostEstablishmentController {

    @Autowired
    IHostEstablishmentService hostEstablishmentService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<HostEstablishmentDTO> findAllSpinnerets() {
        return this.hostEstablishmentService.findAll();
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HostEstablishmentDTO findOneCourse(@PathVariable Long id) {
        return this.hostEstablishmentService.findOne(id);
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public HostEstablishmentDTO addCourse(@RequestBody HostEstablishmentDTO courseDTO) {
        return this.hostEstablishmentService.addHostEstablishment(courseDTO);
    }

    @PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HostEstablishmentDTO editCourse(@RequestBody HostEstablishmentDTO courseDTO, @PathVariable Long id) {
        return this.hostEstablishmentService.editHostEstablishment(courseDTO, id);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteCourse(@PathVariable Long id) {
        this.hostEstablishmentService.deleteHostEstablishment(id);
    }
}
