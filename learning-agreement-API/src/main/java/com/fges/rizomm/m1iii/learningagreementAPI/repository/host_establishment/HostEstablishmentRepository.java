package com.fges.rizomm.m1iii.learningagreementAPI.repository.host_establishment;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.host_establishment.HostEstablishment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostEstablishmentRepository extends JpaRepository<HostEstablishment, Long> {
}