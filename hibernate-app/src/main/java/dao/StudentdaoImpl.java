package dao;

import entityclasses.Students;
import entityclasses.Teachers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.List;

public class StudentdaoImpl implements Studentdao{
    private SessionFactory sessionFactory;

    public void StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Students> fetchAllStudents(int age) {
        Session session = sessionFactory.openSession();
        Query<Students> query = session.createQuery("FROM Student WHERE age = :age", Students.class);
        query.setParameter("age", age);
        List<Students> students = query.list();
        session.close();
        return students;
    }

    @Override
    public Teachers fetchTeacherByStudentId(int studentId) {
        Session session = sessionFactory.openSession();
        Students student = session.get(Students.class, studentId);
        Teachers teacher = student != null ? student.getTeacher() : null;
        session.close();
        return teacher;
    }

    @Override
    public void saveOrUpdateStudent(Students student) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.saveOrUpdate(student);
        transaction.commit();
        session.close();
    }

    @Override
    public void deleteStudent(int studentId) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Students student = session.get(Students.class, studentId);
        if (student != null) {
            session.delete(student);
        }
        transaction.commit();
        session.close();
    }
}
