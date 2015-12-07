
package com.service;

import com.jdbc.DataAccessObject;
import com.model.DetallePedido;
import com.model.Material;
import com.model.SolicitudPedido;
import java.sql.Connection;
import java.util.List;

public interface DetallePedidoInterface {    
    
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(Material mat, SolicitudPedido solPedido) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(DetallePedido obj) throws Exception;   
    public boolean actualizar(DetallePedido obj) throws Exception;
    public DetallePedido buscarPorID(Material mat, SolicitudPedido solPedido) throws Exception;
    
}
