package com.java.dao;

import com.java.pojos.Doctor;
import com.java.mybatis.MyBatisUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class DoctorDao implements InterfaceCrudDao<Doctor> {

    @Override
    public void create(Doctor obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.insert("Doctor.insert", obj);
            session.commit();
        }
    }

    @Override
    public Doctor read(int id) throws Exception {
        Doctor objeto = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            objeto = session.selectOne("Doctor.read", id);
        }
        return objeto;
    }

    @Override
    public void update(Doctor obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.update("Doctor.update", obj);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.delete("Doctor.delete", id);
            session.commit();
        }
    }

    @Override
    public List<Doctor> list() throws Exception {
        List<Doctor> objetos = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            objetos = session.selectList("Doctor.list");
        }
        return objetos;
    }

}
