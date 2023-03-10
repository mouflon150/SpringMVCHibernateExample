package it.kg.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "fistName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "studentFormat")
    private StudyFormat studyFormatEnum;
    @ManyToOne
    @JoinColumn(name = "groups_id")
    private Groups groups;

    public Student(String firstName, String lastName, String email, StudyFormat studyFormatEnum) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.studyFormatEnum = studyFormatEnum;
    }
}
