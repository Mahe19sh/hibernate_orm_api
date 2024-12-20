package service;

import java.util.List;

import entityclasses.Students;
import entityclasses.Teachers;

public interface Servicestudent {
    List<Students> getAllStudentsByAge(int age);
    Teachers getTeacherByStudentId(int studentId);
    void saveOrUpdateStudent(Students student);
    void deleteStudentById(int studentId);
}
