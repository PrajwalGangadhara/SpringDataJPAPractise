package com.practise.SpringDataJPAtutorial.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    @Id
    @SequenceGenerator(
            name="teacher_sequence",
            sequenceName="teacher_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "teacher_sequence"
    )
    private Long teacherId;
    private String firstName;
    private String LastName;

    /* It is recommended to have ManyToOne than OneToMany
    @OneToMany(
            cascade = CascadeType.ALL
    )
    @JoinColumn(
            name="teacher_id",
            referencedColumnName = "teacherId"
    )
    private List<Course> courses;
*/
}
