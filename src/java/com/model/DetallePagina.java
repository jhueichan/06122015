
package com.model;

public class DetallePagina {
      int id;
      Pagina pagina;
      Rol rol;


    public DetallePagina() {
    }

    public Pagina getPagina() {
        return pagina; 
    }

    public void setPagina(Pagina pagina) {
        this.pagina = pagina;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
      
      
}
