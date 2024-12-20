package dao;

import entityclasses.Students;
import entityclasses.Teachers;
import java.util.List;

public interface Studentdao {
    List<Students> fetchAllStudents(int age);
    Teachers fetchTeacherByStudentId(int studentId);
    void saveOrUpdateStudent(Students student);
    void deleteStudent(int studentId);
}
