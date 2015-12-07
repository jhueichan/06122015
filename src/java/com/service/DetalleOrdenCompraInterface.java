
package com.service;

import com.jdbc.DataAccessObject;
import com.model.DetalleOrdenCompra;
import com.model.Material;
import com.model.OrdenCompra;
import java.sql.Connection;
import java.util.List;

public interface DetalleOrdenCompraInterface {    
    
    public static Connection dbConnection= DataAccessObject.getConnection();   
    
    public boolean eliminar(OrdenCompra orden ,Material  mat) throws Exception;
    public List listar() throws Exception;
    public boolean ingresar(DetalleOrdenCompra obj) throws Exception;   
    public boolean actualizar(DetalleOrdenCompra obj) throws Exception;
    public DetalleOrdenCompra buscarPorID(OrdenCompra orden ,Material  mat) throws Exception;
    
}
