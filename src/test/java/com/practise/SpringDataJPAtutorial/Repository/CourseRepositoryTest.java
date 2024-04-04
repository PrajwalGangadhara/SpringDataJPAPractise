package com.practise.SpringDataJPAtutorial.Repository;

import com.practise.SpringDataJPAtutorial.entity.Course;
import com.practise.SpringDataJPAtutorial.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void printCourse()
    {
        List<Course> courses=courseRepository.findAll();
        System.out.println(courses);
    }

    @Test
    public void saveCourseWithTeacher()
    {
        Teacher teacher=Teacher.builder()
                                .firstName("Perry")
                                .LastName("Ellis")
                                .build();

        Course course=Course.builder()
                .title("SQL")
                .credit(7)
                .teacher(teacher)
                .build();
        courseRepository.save(course);
    }

    @Test
    public void fetchwithPagnation()
    {
        /*
        Pageable firstPageWithTwoRecords= PageRequest.of(0, 2);

        List<Course> courseList=courseRepository.findAll(firstPageWithTwoRecords).getContent();
        System.out.println(courseList);

        int pages=courseRepository.findAll(firstPageWithTwoRecords).getTotalPages();
        System.out.println(pages);

        Long totalElements=courseRepository.findAll(firstPageWithTwoRecords).getTotalElements();
        System.out.println(totalElements);
*/
        Pageable secondPageWithThreeRecords= PageRequest.of(1, 3);

        List<Course> courseList1=courseRepository.findAll(secondPageWithThreeRecords).getContent();
        System.out.println(courseList1);

        int pages1=courseRepository.findAll(secondPageWithThreeRecords).getTotalPages();
        System.out.println(pages1);

        Long totalElements1=courseRepository.findAll(secondPageWithThreeRecords).getTotalElements();
        System.out.println(totalElements1);
    }

    @Test
    public void fetchBySorting()
    {
        /* sorting courses with title
        Pageable sortwithTitle=PageRequest.of(0, 5, Sort.by("title"));
        List<Course> courses=courseRepository.findAll(sortwithTitle).getContent();
        System.out.println(courses);
        */

        Pageable sortwithCredit=PageRequest.of(0, 5, Sort.by("credit").descending());
        List<Course> coursesindescOrderofCredit=courseRepository.findAll(sortwithCredit).getContent();
        System.out.println(coursesindescOrderofCredit);

        Pageable sortBytitleAndCreditDesc=PageRequest.of(0, 5, Sort.by("title").and(Sort.by("credit").descending()));


    }

    @Test
    public void fetchContainingwithPageable()
    {
        Pageable firstTeninFirstPage=PageRequest.of(0, 10);
        List<Course> coursesContaining=courseRepository.findByTitleContaining("d", firstTeninFirstPage).getContent();
        System.out.println(coursesContaining);
    }
}