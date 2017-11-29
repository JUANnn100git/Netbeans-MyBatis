package pe.edu.cibertec.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.edu.cibertec.mybatis.MyBatisUtil;
import pe.edu.cibertec.pojos.Usuario;

public class UsuarioDao implements InterfaceCrudDao<Usuario> {

    @Override
    public void create(Usuario obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.insert("Usuario.insert", obj);
            session.commit();
        }
    }

    @Override
    public Usuario read(int id) throws Exception {
        Usuario usuario = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            usuario = session.selectOne("Usuario.read", id);
        }
        return usuario;
    }

    @Override
    public void update(Usuario obj) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.update("Usuario.update", obj);
            session.commit();
        }
    }

    @Override
    public void delete(int id) throws Exception {
        try (SqlSession session = new MyBatisUtil().getSession()) {
            session.delete("Usuario.delete", id);
            session.commit();
        }
    }

    @Override
    public List<Usuario> list() throws Exception {
        List<Usuario> usuarios = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            usuarios = session.selectList("Usuario.list");
        }

        return usuarios;
    }

}
