
package com.dao;
import com.model.Empleado;
import com.model.Proyecto;
import com.model.SolicitudPedido;
import com.service.SolicitudPedidoInterface;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoSolicitudPedido implements SolicitudPedidoInterface {
 DaoEmpleado daoEmpleado= new DaoEmpleado();
  DaoProyecto daoProyecto= new DaoProyecto();
 PreparedStatement pStmt;  
 
 
  public DaoSolicitudPedido() {        
   }

    @Override
    public boolean eliminar(int id) throws Exception {
        String deleteQuery = "DELETE FROM SOL_PEDIDO WHERE NSOLICITUD = ?";
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
       List<SolicitudPedido> solicitudPedidos = new ArrayList<SolicitudPedido>();
      	String query = "SELECT * FROM SOL_PEDNSOLICITUDO ORDER BY NSOLICITUD";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {                    
	            SolicitudPedido solicitudPedido = new SolicitudPedido();                    
                    solicitudPedido.setNumeroSol(rs.getInt(1));
                    Proyecto pro= daoProyecto.buscarPorID(rs.getInt(2));
                    solicitudPedido.setProyecto(pro);
                    Empleado emp=daoEmpleado.buscarPorID(rs.getString(3));
                    solicitudPedido.setEmpleado(emp);
                    solicitudPedido.setFechaEntrega(rs.getDate(4));     
                    solicitudPedidos.add(solicitudPedido);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return solicitudPedidos;   
    }

    @Override
    public boolean ingresar(SolicitudPedido solicitudPedido) throws Exception {
     
        String insertQuery = "INSERT INTO SOL_PEDIDO VALUES (SOL_PEDIDO_SEQ,?,?,?)";
       try {
             	pStmt = dbConnection.prepareStatement(insertQuery);
                
		pStmt.setInt(1, solicitudPedido.getProyecto().getId());
		pStmt.setString(2, solicitudPedido.getEmpleado().getRut());              
		pStmt.setDate(3, solicitudPedido.getFechaEntrega());
                    
        	pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());  
                return false;
	}         
           
    }

    @Override
    public boolean actualizar(SolicitudPedido solicitudPedido) throws Exception {
     
      String updateQuery = "UPDATE SOL_PEDIDO SET PROYECTO_ID = ?, " +
			   "PROYECTO_ID = ?, PROYECTO_ID = ?, "+                            
                           " WHERE NSOLICITUD = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setInt(1, solicitudPedido.getProyecto().getId());
		pStmt.setString(2, solicitudPedido.getEmpleado().getRut());
		pStmt.setDate(3, solicitudPedido.getFechaEntrega());	
                pStmt.setInt(4, solicitudPedido.getNumeroSol());	
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}           
    }

    @Override
    public SolicitudPedido buscarPorID(int id) throws Exception {
      SolicitudPedido solicitudPedido=new SolicitudPedido();
     String query = "SELECT * FROM SOL_PEDIDO WHERE NSOLICITUD = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {               
                   
                    solicitudPedido.setNumeroSol(rs.getInt(1));
                    Proyecto pro= daoProyecto.buscarPorID(rs.getInt(2));
                    solicitudPedido.setProyecto(pro);
                    Empleado emp=daoEmpleado.buscarPorID(rs.getString(3));
                    solicitudPedido.setEmpleado(emp);
                    solicitudPedido.setFechaEntrega(rs.getDate(4));     
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  solicitudPedido;   
    }
    
}
