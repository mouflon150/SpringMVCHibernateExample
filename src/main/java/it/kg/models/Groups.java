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
public class Groups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "groupName")
    private String groupName;
    @Column(name = "dateOfStart")
    private int dateOfStart;
    @Column(name = "dateOfFinish")
    private int dateOfFinish;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    @OneToMany(mappedBy = "groups",cascade = CascadeType.ALL)
    private List<Student>students;
    @ManyToMany(mappedBy = "groups")
    private List<Course> courses;

    public Groups(String groupName, int dateOfStart, int dateOfFinish) {
        this.groupName = groupName;
        this.dateOfStart = dateOfStart;
        this.dateOfFinish = dateOfFinish;
    }
}
