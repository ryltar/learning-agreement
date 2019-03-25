package com.fges.rizomm.m1iii.learningagreementAPI.repository.spinneret;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.spinneret.Spinneret;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpinneretRepository extends JpaRepository<Spinneret, Long> {
}
