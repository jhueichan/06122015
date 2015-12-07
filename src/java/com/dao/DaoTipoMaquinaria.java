/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.jdbc.DataAccessObject;
import com.model.TipoMaquinaria;
import com.service.TipoMaquinariaInterface;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class DaoTipoMaquinaria  implements TipoMaquinariaInterface{
    
    
private Connection dbConnection;
private PreparedStatement pStmt;
private CallableStatement cst;


public DaoTipoMaquinaria() {
	dbConnection = DataAccessObject.getConnection();
}

public TipoMaquinaria buscaPorId(int id){
    
         TipoMaquinaria obj= new TipoMaquinaria();    
          String query = "SELECT * FROM TIPO_MAQ WHERE ID_TIPO_MAQ = ?";   
         //String query  = "call buscaMaterialPorCodigo(?);";	
         try {
                  pStmt = dbConnection.prepareStatement(query);            
		 
                  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			obj.setId(rs.getInt(1));                        
                        obj.setTipo(rs.getString(2));
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
  return  obj;
}

    @Override
    public boolean eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresar(TipoMaquinaria obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(TipoMaquinaria obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public TipoMaquinaria buscarPorID(int id) throws Exception {
      TipoMaquinaria obj= new TipoMaquinaria();    
          String query = "SELECT * FROM TIPO_MAQ WHERE ID_TIPO_MAQ = ?";   
         //String query  = "call buscaMaterialPorCodigo(?);";	
         try {
                  pStmt = dbConnection.prepareStatement(query);            
		 
                  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			obj.setId(rs.getInt(1));                        
                        obj.setTipo(rs.getString(2));
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
     return  obj;
    
    
    }


    
}
