package com.wl.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * 针对学生表的数据访问
 */
public interface StudentDao<T> {

    int PAGE_SIZE = 5;

    List<T> findStudentByPage(int currentPage) throws SQLException;

    List<T> searchStudent(String sname, String sgender) throws SQLException;

    List<T> findAll() throws SQLException;

    void insert(T t) throws SQLException;

    void delete(int sid) throws SQLException;

    void update(T t) throws SQLException;

    T findStudentById(int sid)  throws SQLException ;

    int findCount() throws SQLException;
}
