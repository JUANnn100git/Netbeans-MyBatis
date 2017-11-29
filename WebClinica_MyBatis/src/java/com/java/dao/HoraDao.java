package com.java.dao;

import com.java.pojos.Hora;
import com.java.mybatis.MyBatisUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class HoraDao implements InterfaceCrudDao<Hora> {

    @Override
    public void create(Hora obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.insert("Hora.insert", obj);
            session.commit();
        }
    }

    @Override
    public Hora read(int id) throws Exception {
        Hora objeto = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            objeto = session.selectOne("Hora.read", id);
        }
        return objeto;
    }

    @Override
    public void update(Hora obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.update("Hora.update", obj);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.delete("Hora.delete", id);
            session.commit();
        }
    }

    @Override
    public List<Hora> list() throws Exception {
        List<Hora> objetos = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            objetos = session.selectList("Hora.list");
        }
        return objetos;
    }

}
