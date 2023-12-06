package com.example.student;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.web.WebProperties;

import javax.sound.midi.Sequence;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "student")//Now this tells the Spring Data JPA that this class is an entity in our database
@Table(name ="student",uniqueConstraints={@UniqueConstraint(name = "Student_Constraint_Un",columnNames = "email")})
public class Student {

    @Id//This is an identifier/primary key if we run the code without it then Spring will request for it
    @SequenceGenerator(name ="students_name",allocationSize = 1,sequenceName = "student_sequence")
    @GeneratedValue(strategy = SEQUENCE, generator = "student_sequence")
    @Column(name = "id",updatable = false )
    private long id;

    @Column(name ="first_name",nullable = false, columnDefinition = "TEXT")
    private String firstName;

    @Column(name ="last_name",nullable = false, columnDefinition = "TEXT")
    private String lastName;


    @Column(name ="email",nullable = false, columnDefinition = "TEXT")
    private String email;

    @Column(name ="age")
    private Integer age;

    public Student( String firstName, String lastName, String email, Integer age) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
