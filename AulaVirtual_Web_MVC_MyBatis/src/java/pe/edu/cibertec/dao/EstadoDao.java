package pe.edu.cibertec.dao;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.edu.cibertec.mybatis.MyBatisUtil;
import pe.edu.cibertec.pojos.Estado;

public class EstadoDao implements InterfaceCrudDao<Estado> {

    @Override
    public void create(Estado obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Estado read(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(Estado obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Estado> list() throws Exception {
        List<Estado> estados = null;
        try (SqlSession session = new MyBatisUtil().getSession()) {
            estados = session.selectList("Estado.list");
        }
        return estados;
    }

}
