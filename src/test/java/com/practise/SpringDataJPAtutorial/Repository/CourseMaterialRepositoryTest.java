package com.practise.SpringDataJPAtutorial.Repository;

import com.practise.SpringDataJPAtutorial.entity.Course;
import com.practise.SpringDataJPAtutorial.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void SaveCourseMaterial()
    {
        Course course=Course.builder()
                .title("java")
                .credit(10)
                .build();
        CourseMaterial courseMaterial= CourseMaterial.builder()
                        .url("www.dailycodeBuffer.com")
                                .course(course)
                                        .build();
        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void fetchCourse()
    {
        List<CourseMaterial> courseMaterials=courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }
}