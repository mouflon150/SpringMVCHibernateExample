package it.kg.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
//@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "courseName")
    private String courseName;
    @Column(name = "duration")
    private String duration;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @ManyToMany
    @JoinTable(name = "course_groups", joinColumns = {@JoinColumn(name = "course_id")}, inverseJoinColumns = {@JoinColumn(name = "group_id")})
    private List<Groups> groups;
    @OneToOne(mappedBy = "course", cascade = CascadeType.ALL)
    private Teacher teacher;

    public Course(String courseName, String duration) {
        this.courseName = courseName;
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Course{" +
               "courseName='" + courseName + '\'' +
               ", duration='" + duration + '\'' +
               '}';
    }
}
