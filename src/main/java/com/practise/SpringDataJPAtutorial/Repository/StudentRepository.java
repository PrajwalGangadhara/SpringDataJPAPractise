package com.practise.SpringDataJPAtutorial.Repository;

import com.practise.SpringDataJPAtutorial.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameContaining(String MatchingString);

    List<Student> findByFirstNameIsNull();

    List<Student> findByFirstNameAndLastName(String firstName, String LastName);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    List<Student> getStudentByEmailAddress(String emailId);

    //JPQL
    @Query("select s.firstName from Student s where s.emailId=?1")
    String getFirstNameByEmailAddress(String emailId);

    //Native Query
    @Query(
            value = "SELECT * FROM tbl_student s where s.last_name=?1",
            nativeQuery = true
    )
    public Student findByLastNameNative(String lastname);

    //Native Query named params
    @Query(
            value = "SELECT * FROM tbl_student s where s.guardian_name= :guardianName",
            nativeQuery = true
    )
    public Student findByGaurdianNameNative(@Param("guardianName") String guardianName);

    @Modifying
    @Transactional
    @Query(
            value = "update tbl_student set first_name=?1 where email_address=?2",
            nativeQuery = true
    )
    public void updateFirstNameHavingEmailId(String firstName, String emailId);
}
