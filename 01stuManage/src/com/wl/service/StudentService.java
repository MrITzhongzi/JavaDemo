package com.wl.service;

import com.wl.domain.PageStudentBean;

import java.sql.SQLException;
import java.util.List;

public interface StudentService<T> {

    PageStudentBean<T> findStudentByPage(int currentPage) throws SQLException;

    List<T> searchStudent(String sname, String sgender) throws SQLException;

    List<T> findAll() throws SQLException;

    void insert(T t) throws SQLException;

    void delete(int sid) throws SQLException;

    void update(T t) throws SQLException;

    T findStudentById(int sid)  throws SQLException ;
}
