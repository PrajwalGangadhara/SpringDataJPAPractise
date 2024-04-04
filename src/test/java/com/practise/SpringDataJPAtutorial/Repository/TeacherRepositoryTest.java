package com.practise.SpringDataJPAtutorial.Repository;

import com.practise.SpringDataJPAtutorial.entity.Course;
import com.practise.SpringDataJPAtutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TeacherRepositoryTest {

    @Autowired
    private TeacherRepository teacherRepository;

    @Test
    void saveTeacher()
    {
        Course DBA_course= Course.builder()
                .title("DBA")
                .credit(8)
                .build();

        Course Python_course= Course.builder()
                .title("Python")
                .credit(9)
                .build();

        Teacher teacher=Teacher.builder()
                .firstName("Ayesha")
                .LastName("Khan")
                //.courses(List.of(DBA_course, Python_course)) commenting as we commented Course part in teacher class
                .build();
        teacherRepository.save(teacher);
    }
}