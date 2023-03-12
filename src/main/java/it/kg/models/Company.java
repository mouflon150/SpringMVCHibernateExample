package it.kg.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id")
    private int id;
    @Column(name = "company_name")
    private String companyName;
    @Column(name = "located_country")
    private String locatedCountry;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
    )
    private List<Course> courses;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL
            , fetch = FetchType.LAZY
    )
    private List<Group> groups;

    public Company() {
    }

    public Company(String companyName, String locatedCountry, List<Course> courses, List<Group> groups) {
        this.companyName = companyName;
        this.locatedCountry = locatedCountry;
        this.courses = courses;
        this.groups = groups;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getLocatedCountry() {
        return locatedCountry;
    }

    public void setLocatedCountry(String locatedCountry) {
        this.locatedCountry = locatedCountry;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public List<Group> getGroups() {
        return groups;
    }

    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", locatedCountry='" + locatedCountry + '\'' +
                ", courses=" + courses +
                ", groups=" + groups +
                '}';
    }
}