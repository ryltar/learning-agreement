package com.fges.rizomm.m1iii.learningagreementAPI.services.course;

import com.fges.rizomm.m1iii.learningagreementAPI.dto.course.CourseDTO;
import com.fges.rizomm.m1iii.learningagreementAPI.entity.course.Course;
import com.fges.rizomm.m1iii.learningagreementAPI.services.SuperService;

public class CourseService extends SuperService<Course, CourseDTO> implements ICourseService {

    public CourseDTO entityToDto(Course entity) {
        return super.getMapper().map(entity, CourseDTO.class);
    }

    public Course dtoToEntity(CourseDTO dto) {
        return super.getMapper().map(dto, Course.class);
    }
}
