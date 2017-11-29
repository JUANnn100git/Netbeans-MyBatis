/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.List;
import org.apache.ibatis.session.SqlSession;
import pe.edu.cibertec.mybatis.MyBatisUtil;
import pe.edu.cibertec.pojos.Usuario;
/**
 *
 * @author JuanVillanueva
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Usuario> usuarios = getUsuarios();
        System.out.println(usuarios);
        for (Usuario u : usuarios){
            System.out.println(u.getId() + " " +
                    u.getNombreUsuario() + " " +
                    u.getNombres() + " " +
                    u.getApellidos() + " " +
                   u.getCorreo()  + " " + 
                    u.getEstado().getId() + " " + u.getEstado().getNombre());
        }
    }

    public static List<Usuario> getUsuarios() {
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
