package pe.edu.cibertec.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.edu.cibertec.mybatis.MyBatisUtil;
import pe.edu.cibertec.pojos.Rol;

public class RolDao implements InterfaceCrudDao<Rol> {

    @Override
    public void create(Rol obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Rol read(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Rol obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Rol> list() throws Exception {
        List<Rol> roles = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            roles = session.selectList("Rol.list");
        }
        return roles;
    }

}
