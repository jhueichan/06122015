
package com.service;

import com.jdbc.DataAccessObject;
import com.model.TipoMaquinaria;
import java.sql.Connection;
import java.util.List;

public interface TipoMaquinariaInterface {
    public static Connection dbConnection = DataAccessObject.getConnection();   
   public boolean eliminar(int id) throws Exception;
    public List <TipoMaquinaria> listar() throws Exception;
    public boolean ingresar(TipoMaquinaria obj) throws Exception;   
    public boolean actualizar(TipoMaquinaria obj) throws Exception;
    public TipoMaquinaria buscarPorID(int id) throws Exception;
   
}
