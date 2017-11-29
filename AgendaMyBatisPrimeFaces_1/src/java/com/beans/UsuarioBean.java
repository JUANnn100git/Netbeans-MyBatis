package com.beans;

import com.mybatis.MyBatisUtil;
import com.mybatis.pojos.Usuario;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.apache.ibatis.session.SqlSession;

@ManagedBean
@RequestScoped
public class UsuarioBean {

    private Usuario usuario;

    public UsuarioBean() {
        usuario = new Usuario();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> lista = null;
        SqlSession session = new MyBatisUtil().getSession();
        if (session != null) {
            try {
                lista = session.selectList("Usuario.list");
            } finally {
                session.close();
            }
        } else {
            System.out.println("ERROR");
        }
        return lista;
    }
}
