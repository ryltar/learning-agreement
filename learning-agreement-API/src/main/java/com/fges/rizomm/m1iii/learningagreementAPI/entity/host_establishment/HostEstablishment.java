package com.fges.rizomm.m1iii.learningagreementAPI.entity.host_establishment;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.LearningEntity;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Partner;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HostEstablishment")
public class HostEstablishment extends LearningEntity<Long> implements Serializable {
    private String name;
    private String country;
    @OneToMany(mappedBy="hostestablishment")
    private List<Partner> partners;
}
