
package com.dao;
import com.model.Pagina;
import com.model.Privilegios;
import com.model.Rol;
import com.service.RolInterface;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class DaoRol implements RolInterface{
    PreparedStatement pStmt;      
    CallableStatement csts;
    DaoPrivilegios daoPrivilegios= new  DaoPrivilegios();
             
    
    public DaoRol() {
    }

    @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM ROL WHERE ID = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1, id);
		pStmt.executeUpdate();
                return true;   
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;   
	}
        
    }

    @Override
    public List listar() throws Exception {
     List<Rol> roles = new ArrayList<Rol>();        
	String query = "SELECT * FROM ROL";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			Rol rol = new Rol();
			rol.setId(rs.getInt(1));
			rol.setNombres(rs.getString(2));   
                        Privilegios pri=daoPrivilegios.buscarPorID(rs.getInt(3));
                        rol.setPrivilegios(pri); 
                        roles.add(rol);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return roles;
    }

    @Override
    public boolean ingresar(Rol obj) throws Exception {
       String insertQuery = "INSERT INTO ROL VALUES (ROL_SEQ.NextVal,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, obj.getNombres());	
                pStmt.setInt(2, obj.getId());	
        	pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(Rol obj) throws Exception {
      String updateQuery = "UPDATE ROL SET NOMBRE = ?, PRIVILEGIOS = ? WHERE ID  = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, obj.getNombres());
                pStmt.setInt(2, obj.getPrivilegios().getIdpriv());
		pStmt.setInt(3, obj.getId());
		pStmt.executeUpdate();
                 return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  Rol buscarPorID(int id) throws Exception {
     Rol rol=new Rol();
     String query = "SELECT * FROM ROL WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
			rol.setId(rs.getInt(1));
			rol.setNombres(rs.getString(2));   
                        Privilegios pri = daoPrivilegios.buscarPorID(rs.getInt(3));
                        rol.setPrivilegios(pri); 
		} 	
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  rol;   
    }

   



}
