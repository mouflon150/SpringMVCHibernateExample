package it.kg;

import it.kg.models.*;
import it.kg.service.CompanyService;
import it.kg.service.impl.CompanyServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class App {

    public static void main(String[] args) {

        Company company = new Company();
        company.setCompanyName("IT.KG");
        company.setLocatedCountry("Kyrgyzstan");

        Group group1 = new Group();
        group1.setGroupName("1-A Java");
        group1.setDateOfStart("October 10");
        group1.setDateOfFinish("June 20-30");

        Group group2 = new Group();
        group2.setGroupName("1-A JS");
        group2.setDateOfStart("November 10");
        group2.setDateOfFinish("July 10-20");

        List<Group> groups = new ArrayList<Group>();
        groups.add(group1);
        groups.add(group2);

        group1.setCompany(company);
        group2.setCompany(company);
        company.setGroups(groups);

        Course course1 = new Course();
        course1.setCourseName("Java Backend");
        course1.setDuration("9 months");

        Course course2 = new Course();
        course2.setCourseName("JavaScript");
        course2.setDuration("9 months");

        List<Course> courses = new ArrayList<Course>();
        courses.add(course1);
        courses.add(course2);
        course1.setCompany(company);
        course2.setCompany(company);
        company.setCourses(courses);

//        group1.getCourses().add(course1);
//        course1.getGroups().add(group1);
        group1.setCourses(courses);
        course1.setGroups(groups);

//        group2.getCourses().add(course2);
//        course2.getGroups().add(group2);
        group2.setCourses(courses);
        course2.setGroups(groups);

        Student student1 = new Student();
        student1.setFirstName("Marlen");
        student1.setLastName("Temirbaev");
        student1.setStudyFormat(StudyFormat.ONLINE);
        student1.setEmail("mtemirbaev86@gmail.com");

        Student student2 = new Student();
        student2.setFirstName("Daniel");
        student2.setLastName("Ahadzanov");
        student2.setStudyFormat(StudyFormat.OFFLINE);
        student2.setEmail("doncha@gmail.com");

        Student student3 = new Student();
        student3.setFirstName("Dastan");
        student3.setLastName("Abdullaev");
        student3.setStudyFormat(StudyFormat.OFFLINE);
        student3.setEmail("dasti_dobryi@gmail.com");

        List<Student> students1 = new ArrayList<Student>();
        students1.add(student1);
        students1.add(student2);

        List<Student> students2 = new ArrayList<Student>();
        students2.add(student3);

        student1.setGroup(group1);
        student2.setGroup(group1);
        student3.setGroup(group2);
        group1.setStudents(students1);
        group2.setStudents(students2);

        Teacher teacher1 = new Teacher();
        teacher1.setFirstName("Elmirbek");
        teacher1.setLastName("Alisherov");
        teacher1.setEmail("emirdev@gmail.com");
        teacher1.setCourse(course1);
        course1.setTeacher(teacher1);

        Teacher teacher2 = new Teacher();
        teacher2.setFirstName("Bilal");
        teacher2.setLastName("Baitov");
        teacher2.setEmail("bilalov@gmail.com");
        teacher2.setCourse(course2);
        course2.setTeacher(teacher2);

        CompanyService companyService = new CompanyServiceImpl();
        companyService.save(company);
    }
}