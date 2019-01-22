package com.wl.dao.impl;

import com.wl.dao.StudentDao;
import com.wl.domain.Student;
import com.wl.util.JDBCUtil02;
import com.wl.util.TextUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * studentdao的实现
 */
public class StudentDaoImpl implements StudentDao<Student> {


    @Override
    public List<Student> findStudentByPage(int currentPage) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        return runner.query("select * from stu limit ? offset ?", new BeanListHandler<Student>(Student.class), PAGE_SIZE, PAGE_SIZE * (currentPage - 1));
    }

    @Override
    public List<Student> searchStudent(String sname, String sgender) throws SQLException {

        try{
            QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
            String sql = "select * from stu where 1 = 1 ";
            List<String> listPara = new ArrayList<>();
            if(!TextUtils.isEmpty(sname)){
                sql = sql + " and sname like ? ";
                sname = "%" + sname + "%";
                listPara.add(sname);
            }
            if(!TextUtils.isEmpty(sgender)){
                sql = sql + " and gender = ?";
                listPara.add(sgender);
            }
            List<Student> query = queryRunner.query(sql, new BeanListHandler<Student>(Student.class), listPara.toArray());
            return query;
        } catch (Exception e){
            e.printStackTrace();
        }


        return null;
    }

    /***
     * 查询所有学生
     * @return
     */
    @Override
    public List<Student> findAll() throws SQLException {
        QueryRunner queryRunner = new QueryRunner(JDBCUtil02.getDataSource());
        String sql = "select * from stu";

        List<Student> list = queryRunner.query(sql, new BeanListHandler<Student>(Student.class));
        return list;
    }

    @Override
    public void insert(Student student) throws SQLException {

        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        try {
            Object[] params = new Object[]{
                    student.getSname(),
                    student.getGender(),
                    student.getPhone(),
                    new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()),
                    student.getHobby(),
                    student.getInfo()
            };
            String sql = "insert into stu values (null,?,?,?,?,?,?)";
            runner.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        runner.update("delete from stu where sid = ?", sid);
    }

    @Override
    public void update(Student student) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        try {
            Object[] params = new Object[]{
                    student.getSname(),
                    student.getGender(),
                    student.getPhone(),
                    new SimpleDateFormat("yyyy-MM-dd").format(student.getBirthday()),
                    student.getHobby(),
                    student.getInfo(),
                    student.getSid()
            };
            String sql = "update stu set sname=?,gender=?,phone=?,birthday=?,hobby=?,info=? where sid = ?";
            runner.update(sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Student findStudentById(int sid) throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        Student query = runner.query("select * from stu where sid = ?", new BeanHandler<Student>(Student.class), sid);
        return query;
    }

    @Override
    public int findCount() throws SQLException {
        QueryRunner runner = new QueryRunner(JDBCUtil02.getDataSource());
        return ((Long)runner.query("select count(*) from stu", new ScalarHandler())).intValue();
    }
}
