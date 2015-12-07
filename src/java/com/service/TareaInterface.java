
package com.service;

import com.jdbc.DataAccessObject;
import com.model.Tarea;
import java.sql.Connection;
import java.util.List;

public interface TareaInterface {
    public static Connection dbConnection= DataAccessObject.getConnection();  
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(Tarea obj) throws Exception;   
    public boolean actualizar(Tarea obj) throws Exception;
    public Tarea buscarPorID(int id) throws Exception;
}
