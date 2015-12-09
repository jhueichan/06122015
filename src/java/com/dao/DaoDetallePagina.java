
package com.dao;

import com.model.DetallePagina;
import com.service.DetallePaginaInterface;
import java.sql.PreparedStatement;
import java.util.List;


public class DaoDetallePagina implements DetallePaginaInterface{
   PreparedStatement pStmt;  

    public DaoDetallePagina() {
    }

    @Override
    public boolean eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<DetallePagina> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresar(DetallePagina obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(DetallePagina obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetallePagina buscarPorID(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
   
   
   
}
