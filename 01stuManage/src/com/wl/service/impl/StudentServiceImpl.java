package com.wl.service.impl;

import com.wl.dao.StudentDao;
import com.wl.dao.impl.StudentDaoImpl;
import com.wl.domain.PageStudentBean;
import com.wl.domain.Student;
import com.wl.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService<Student> {

    @Override
    public PageStudentBean<Student> findStudentByPage(int currentPage) throws SQLException {
        PageStudentBean<Student> pageBean = new PageStudentBean<>();

        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(StudentDao.PAGE_SIZE);
        StudentDao<Student> studentDao = new StudentDaoImpl();
        pageBean.setList(studentDao.findStudentByPage(currentPage));
        int allCount = studentDao.findCount();
        pageBean.setTotalSize(allCount);
        pageBean.setTotalPage(allCount % StudentDao.PAGE_SIZE == 0 ? allCount / StudentDao.PAGE_SIZE : allCount / StudentDao.PAGE_SIZE + 1);

        return pageBean;
    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {
        StudentDao<Student> dao = new StudentDaoImpl();
        List<Student> list = dao.searchStudent(sname, sgender);
        return  list;
    }

    /***
     * 这是学生业务实现
     * @return
     * @throws SQLException
     */
    @Override
    public List<Student> findAll() throws SQLException {
        StudentDao<Student> dao = new StudentDaoImpl();
        return dao.findAll();
    }

    @Override
    public void insert(Student student) throws SQLException {
        StudentDao<Student> dao = new StudentDaoImpl();
        dao.insert(student);
    }

    @Override
    public void delete(int sid) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.delete(sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        StudentDao dao = new StudentDaoImpl();
        dao.update(student);
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        StudentDao<Student> dao = new StudentDaoImpl();
        Student studentById = dao.findStudentById(sid);
        return studentById;
    }
}
