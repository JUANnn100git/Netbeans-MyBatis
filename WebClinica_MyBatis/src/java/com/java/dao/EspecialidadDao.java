package com.java.dao;

import com.java.pojos.Especialidad;
import com.java.mybatis.MyBatisUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class EspecialidadDao implements InterfaceCrudDao<Especialidad> {

    @Override
    public void create(Especialidad obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.insert("Especialidad.insert", obj);
            session.commit();
        }
    }

    @Override
    public Especialidad read(int id) throws Exception {
        Especialidad especialidad = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            especialidad = session.selectOne("Especialidad.read", id);
        }
        return especialidad;
    }

    @Override
    public void update(Especialidad obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.update("Especialidad.update", obj);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.delete("Especialidad.delete", id);
            session.commit();
        }
    }

    @Override
    public List<Especialidad> list() throws Exception {
        List<Especialidad> especialidades = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            especialidades = session.selectList("Especialidad.list");
        }
        return especialidades;
    }

}
