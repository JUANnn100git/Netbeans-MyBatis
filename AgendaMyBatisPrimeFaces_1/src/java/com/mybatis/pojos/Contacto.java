package com.mybatis.pojos;

public class Contacto {

    private int id;
    private String nombre;
    private String apellidos;
    private int numero;

    public Contacto() {
    }

    public Contacto(int id, String nombre, String apellidos, int numero) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
    }

    public Contacto(String nombre, String apellidos, int numero) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.numero = numero;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellidos;
    }

    public void setApellido(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return nombre + "-----" + numero;
    }

}
