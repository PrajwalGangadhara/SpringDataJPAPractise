package com.practise.SpringDataJPAtutorial.Repository;

import com.practise.SpringDataJPAtutorial.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
