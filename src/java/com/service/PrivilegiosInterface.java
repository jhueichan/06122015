
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Privilegios;
import java.sql.Connection;
import java.util.List;

public interface PrivilegiosInterface {
   public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Privilegios obj) throws Exception;   
    public boolean actualizar(Privilegios obj) throws Exception;
    public Privilegios buscarPorID(int id) throws Exception;  
}
