package com.java.dao;

import com.java.pojos.HorarioAtencionDr;
import com.java.mybatis.MyBatisUtil;
import java.util.List;
import org.apache.ibatis.session.SqlSession;

public class HorarioAtencionDrDao implements InterfaceCrudDao<HorarioAtencionDr> {

    @Override
    public void create(HorarioAtencionDr obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.insert("HorarioAtencionDr.insert", obj);
            session.commit();
        }
    }

    @Override
    public HorarioAtencionDr read(int id) throws Exception {
        HorarioAtencionDr objeto = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            objeto = session.selectOne("HorarioAtencionDr.read", id);
        }
        return objeto;
    }

    @Override
    public void update(HorarioAtencionDr obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.update("HorarioAtencionDr.update", obj);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.delete("HorarioAtencionDr.delete", id);
            session.commit();
        }
    }

    @Override
    public List<HorarioAtencionDr> list() throws Exception {
        List<HorarioAtencionDr> objetos = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            objetos = session.selectList("HorarioAtencionDr.list");
        }
        return objetos;
    }

}
