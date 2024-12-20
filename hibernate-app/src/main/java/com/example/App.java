package com.example;

import javax.security.auth.login.Configuration;

import com.mysql.cj.xdevapi.SessionFactory;

import dao.Studentdao;
import dao.StudentdaoImpl;
import entityclasses.Courses;
import entityclasses.Students;
import entityclasses.Teachers;
import service.ServiceImpl;
import service.Servicestudent;

/**
 * Hello world!
 */
public final class App {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Students.class)
                .addAnnotatedClass(Teachers.class)
                .addAnnotatedClass(Courses.class)
                .buildSessionFactory();

        // Initialize DAOs and Services
        Studentdao studentDAO = new StudentdaoImpl(sessionFactory);
        Servicestudent studentService = new ServiceImpl(studentDAO);

        // Example Usage
        System.out.println("Starting Application...");

        // Create and save a new Teacher
        Teachers teacher = new Teacher();
        teacher.setName("John Doe");

        Students student = new Student();
        student.setName("Alice");
        student.setAge(20);
        student.setTeacher(teacher);

        Courses course = new Course();
        course.setter("Mathematics");
        course.setter(student);

        // Save entities to DB
        studentService.saveOrUpdateStudent(student);

        // Fetch all students (filtered by age)
        System.out.println("Fetching all students aged 20...");
        studentService.getAllStudentsByAge(20).forEach(s -> System.out.println(s.getName()));

        // Fetch teacher by student ID
        System.out.println("Fetching teacher for student with ID 1...");
        Teachers fetchedTeacher = studentService.getTeacherByStudentId(1);
        if (fetchedTeacher != null) {
            System.out.println("Teacher: " + fetchedTeacher.getName());
        } else {
            System.out.println("No teacher found for student ID 1");
        }

        // Clean up Hibernate resources
        sessionFactory.close();
    }
}
