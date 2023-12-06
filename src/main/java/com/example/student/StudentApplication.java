package com.example.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentApplication.class, args);
    }
 CommandLineRunner commandLineRunner(StudentRepository studentRepository){
     return args->{
         Student maria = new Student("maria","chioma","@mariachaser",14);
         studentRepository.save(maria);
         studentRepository.delete(maria);
     };
    }
}
