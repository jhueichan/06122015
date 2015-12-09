
package com.model;

public class Rol {
    private  int id;
    private String nombres;
    private Privilegios  privilegios;

    public Rol() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Privilegios getPrivilegios() {
        return privilegios;
    }

    public void setPrivilegios(Privilegios privilegios) {
        this.privilegios = privilegios;
    }

 
    
    
}
