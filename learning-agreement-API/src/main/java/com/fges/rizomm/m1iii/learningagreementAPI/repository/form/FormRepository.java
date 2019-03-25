package com.fges.rizomm.m1iii.learningagreementAPI.repository.form;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.form.Form;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormRepository extends JpaRepository<Form, Long> {
}
