
package com.service;

import com.jdbc.DataAccessObject;
import com.model.SolicitudPedido;
import java.sql.Connection;
import java.util.List;

public interface SolicitudPedidoInterface {
    
    public static Connection dbConnection= DataAccessObject.getConnection();    
    public boolean eliminar(int id) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(SolicitudPedido obj) throws Exception;   
    public boolean actualizar(SolicitudPedido obj) throws Exception;
    public SolicitudPedido buscarPorID(int id) throws Exception;  
    
    
    
}
