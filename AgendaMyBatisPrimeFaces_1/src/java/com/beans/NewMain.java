/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.beans;

import com.mybatis.pojos.Usuario;
import java.util.List;

/**
 *
 * @author JuanVillanueva
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       UsuarioBean bean = new UsuarioBean();
       List<Usuario> lista = bean.getUsuarios();
        System.out.println(lista);
    }
    
}
