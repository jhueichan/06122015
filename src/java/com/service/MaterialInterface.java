
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Material;
import java.sql.Connection;
import java.util.List;

public interface MaterialInterface {
    
     public static Connection dbConnection = DataAccessObject.getConnection();   
   
    public boolean eliminar(int id) throws Exception;
    public List<Material>  listar() throws Exception;
    public boolean ingresar(Material obj) throws Exception;   
    public boolean actualizar(Material obj) throws Exception;
    public Material buscarPorID(int id) throws Exception;
    
}
