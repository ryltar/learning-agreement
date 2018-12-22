package com.fges.rizomm.m1iii.learningagreementAPI.entity.spinneret;

import com.fges.rizomm.m1iii.learningagreementAPI.entity.LearningEntity;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.user.Student;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Spinneret")
public class Spinneret extends LearningEntity<Long> implements Serializable {

    private static final long serialVersionUID = 1L;
    private String level;
    private String label;
    @ManyToMany(mappedBy = "spinnerets")
    private List<Student> students;

}
