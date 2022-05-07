package com.codebuffer.spring.data.jpa.tutorial.repository;

import com.codebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.codebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent() {
        Student student = Student.builder()
                .emailId("shabbir@gmail.com")
                .firstName("Shabbir")
                .lastName("Dawoodi")
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWihtGuardin() {
        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .mobile("9999956324")
                .build();

        Student student = Student.builder()
                .emailId("shivam@gmail.com")
                .firstName("Shiwam")
                .lastName("Kumar")
                .guardian(guardian)
//                .guardianName("Nikhil")
//                .guardianEmail("nikhil@gmail.com")
//                .guardianMobile("9999999999")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudent() {
        List<Student> studentList = studentRepository.findAll();

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstName() {
        List<Student> studentList = studentRepository.findByFirstName("Shiwam");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentByFirstNameContaining() {
        List<Student> studentList = studentRepository.findByFirstNameContaining("Sh");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasesOnGuardianName() {
        List<Student> studentList = studentRepository.findByGuardianName("Nikhil");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentNotNull() {
        List<Student> studentList = studentRepository.findByGuardianName("Nikhil");

        System.out.println("studentList = " + studentList);
    }

    @Test
    public void printStudentBasedOnEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("shabbir@gmail.com");

        System.out.println("studentList = " + student);
    }

    @Test
    public void printStudentFirstNameBasedOnEmailAddress() {
        String student = studentRepository.getStudentFirstNameByEmailAddress("shabbir@gmail.com");

        System.out.println("studentFirstName = " + student);
    }

    @Test
    public void printStudentFirstNameBasedOnEmailAddressNative() {
        String student = studentRepository.getStudentFirstNameByEmailAddressNative("shabbir@gmail.com");

        System.out.println("studentFirstName = " + student);
    }

    @Test
    public void printStudentFirstNameBasedOnEmailAddressNativeNamedParam() {
        String student = studentRepository.getStudentFirstNameByEmailAddressNativeNamedParam("shabbir@gmail.com");

        System.out.println("studentFirstName = " + student);
    }

    @Test
    public void updateStudentNameByEmailTest() {
        studentRepository.updateStudentNameByEmail("shabir dawoodi","shabbir@gmail.com");
    }
}
