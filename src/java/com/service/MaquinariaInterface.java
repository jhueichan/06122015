
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Maquinaria;
import java.sql.Connection;
import java.util.List;


public interface  MaquinariaInterface {
    
    public static Connection dbConnection= DataAccessObject.getConnection();
    
    public boolean eliminar(String patente) throws Exception;
    public List <Maquinaria> listar() throws Exception;
    public boolean ingresar(Maquinaria obj) throws Exception;   
    public boolean actualizar(Maquinaria obj) throws Exception;
    public Maquinaria buscarPorID(String patente) throws Exception;
}

