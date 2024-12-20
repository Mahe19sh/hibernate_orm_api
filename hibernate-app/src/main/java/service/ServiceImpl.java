package service;

import java.util.List;

import dao.Studentdao;
import entityclasses.Students;
import entityclasses.Teachers;

public class ServiceImpl implements Servicestudent{
    private Studentdao studentDAO;

    public ServiceImpl(Studentdao studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Students> getAllStudentsByAge(int age) {
        return studentDAO.fetchAllStudents(age);
    }

    @Override
    public Teachers getTeacherByStudentId(int studentId) {
        return studentDAO.fetchTeacherByStudentId(studentId);
    }

    @Override
    public void saveOrUpdateStudent(Students student) {
        studentDAO.saveOrUpdateStudent(student);
    }

    @Override
    public void deleteStudentById(int studentId) {
        studentDAO.deleteStudent(studentId);
    }
}
