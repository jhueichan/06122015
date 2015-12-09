
package com.dao;

import com.model.Privilegios;
import com.service.PrivilegiosInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoPrivilegios implements PrivilegiosInterface{
    
     PreparedStatement pStmt;  
  
     
     public DaoPrivilegios() {
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
    public boolean ingresar(Privilegios obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(Privilegios obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Privilegios buscarPorID(int id) throws Exception {
       Privilegios privilegio= new Privilegios();       
      
       String query = "SELECT * FROM PRIVILEGIOS WHERE IDPRIV = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			privilegio.setIdpriv(rs.getInt(1));
			privilegio.setNom_priv(rs.getString(2));                  
                  } 	
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}       
       return privilegio;
    }
  
    
   
    
}
