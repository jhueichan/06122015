
package com.service;

import com.jdbc.DataAccessObject;
import com.model.PrivilegiosPagina;
import java.sql.Connection;
import java.util.List;


public interface PrivilegiosPaginaInterface {
       
    public static Connection dbConnection= DataAccessObject.getConnection();
    public boolean eliminar(int privpagina) throws Exception;
    public List <PrivilegiosPagina> listar() throws Exception;
    public boolean ingresar(PrivilegiosPagina obj) throws Exception;   
    public boolean actualizar(PrivilegiosPagina obj) throws Exception;
    public PrivilegiosPagina buscarPorID(int privpagina)  throws Exception;

    
    
    
}
