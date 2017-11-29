 package com.beans;

import com.mybatis.MyBatisUtil;
import com.mybatis.pojos.Contacto;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.apache.ibatis.session.SqlSession;

@ManagedBean
@RequestScoped
public class ContactoBean {

    private Contacto contacto;

    public ContactoBean() {
        contacto = new Contacto();
    }

    public Contacto getContacto() {
        return contacto;
    }

    public void setContacto(Contacto contacto) {
        this.contacto = contacto;
    }

    public String guardar() {
        //asignar un id por defecto
        contacto.setId(-1);
        SqlSession session = new MyBatisUtil().getSession();
        if (session != null) {
            try {
                session.insert("Contacto.insertContacto", contacto);
                session.commit();
            } finally {
                session.close();
            }
        } else {
            System.out.println("ERROR");
        }
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Contacto creado"));
        return "index";
    }

    public List<Contacto> getContactos() {
        List<Contacto> lista = null;
        SqlSession session = new MyBatisUtil().getSession();
        if (session != null) {
            try {
                lista = session.selectList("Contacto.getContactos");
            } finally {
                session.close();
            }
        } else {
            System.out.println("ERROR");
        }
        return lista;
    }
}
