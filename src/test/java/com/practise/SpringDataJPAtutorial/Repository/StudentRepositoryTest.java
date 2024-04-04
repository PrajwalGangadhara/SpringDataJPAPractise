package com.practise.SpringDataJPAtutorial.Repository;

import com.practise.SpringDataJPAtutorial.entity.Guardian;
import com.practise.SpringDataJPAtutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void saveStudnet()
    {
        Student student= Student.builder()
                .firstName("Prajwal")
                .lastName("G")
                .emailId("Prajwal@gmail.com")
                //.guardianName("Gangadhar")
                //.guardianEMail("gan@gmail.com")
                //.guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }
    Guardian guardian=Guardian.builder()
            .name("Starc")
            .email("starc@gmail.com")
            .mobile("1013839382")
            .build();

    @Test
    void saveStudentWithGuardian()
    {
        Student st=Student.builder()
                .firstName("David")
                .lastName("miller")
                .emailId("david@gmail.com")
                .guardian(guardian)
                .build();

        studentRepository.save(st);
    }

    @Test
    void fetchStudent()
    {
      List<Student> studentList = studentRepository.findAll();
        System.out.println("Studentlist" + studentList);
    }

    @Test
    void findByFirstNameContaining()
    {
        List<Student> studentList=studentRepository.findByFirstNameContaining("Pra");
        System.out.println(studentList);
    }

    @Test
    void findByFirstNameIsNotNull()
    {
        List<Student> studentList=studentRepository.findByFirstNameIsNull();
        System.out.println(studentList);
    }

    @Test
    void findByFirstNameAndLastName()
    {
        List<Student> studentList=studentRepository.findByFirstNameAndLastName("David", "miller");
        System.out.println(studentList);
    }

    @Test
    public void findByEmailId()
    {
        List<Student> studentlist=studentRepository.getStudentByEmailAddress("david@gmail.com");
        System.out.println(studentlist);
    }

    @Test
    public void getFirstNameByEmailAddress()
    {
        System.out.println(studentRepository.getFirstNameByEmailAddress("david@gmail.com"));
    }

    @Test
    public void getLastNameByNativeQuery()
    {
        Student student=studentRepository.findByLastNameNative("g");
        System.out.println(student.getFirstName()+student.getLastName());
    }

    @Test
    public void findByGaurdianNameNative()
    {
        Student student=studentRepository.findByGaurdianNameNative("Gangadhar");
        System.out.println(student);
    }

    @Test
    public void updateFirstNameHavingEmailId()
    {
        studentRepository.updateFirstNameHavingEmailId("David don", "david@gmail.com");
    }
}