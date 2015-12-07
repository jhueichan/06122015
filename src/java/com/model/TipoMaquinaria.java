
package com.model;

public class TipoMaquinaria {
     private int id;
     private String tipo;

    public TipoMaquinaria() {
    }

    public TipoMaquinaria(int id, String tipo) {
        this.id = id;
        this.tipo = tipo;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
       
    
    
    
}
