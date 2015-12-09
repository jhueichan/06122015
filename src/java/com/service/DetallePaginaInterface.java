
package com.service;
import com.jdbc.DataAccessObject;
import com.model.DetallePagina;
import java.sql.Connection;
import java.util.List;
public interface DetallePaginaInterface {
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(int id) throws Exception;
    public List <DetallePagina>listar() throws Exception;
    public boolean ingresar(DetallePagina obj) throws Exception;   
    public boolean actualizar(DetallePagina obj) throws Exception;
    public DetallePagina buscarPorID(int id) throws Exception;
}
