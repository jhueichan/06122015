
package com.dao;

import com.model.Empleado;
import com.model.Proyecto;
import com.model.Tarea;
import com.service.TareaInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoTarea implements TareaInterface{
 DaoEmpleado daoEmpleado= new DaoEmpleado();
 DaoProyecto daoProyecto= new  DaoProyecto();
 PreparedStatement pStmt; 
    @Override
    public boolean eliminar(int id) throws Exception {
      String deleteQuery = "DELETE FROM TAREA WHERE ID_TAREA = ?";
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
      List<Tarea> tareas = new ArrayList<Tarea>();
      	String query = "SELECT * FROM TAREA ORDER BY ID_TAREA";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {                                    
	            Tarea tarea = new Tarea();
                    
                    tarea.setId(rs.getInt(1));
                    tarea.setNombreTarea(rs.getString(2));
                    tarea.setFechaInicio(rs.getDate(3));
                    tarea.setFechaTermino(rs.getDate(4));
                    Empleado responsable=daoEmpleado.buscarPorID(rs.getString(5));
                    tarea.setResponsable(responsable);
                    Proyecto pro= daoProyecto.buscarPorID(rs.getInt(6));
                    tarea.setProyecto(pro);
                    tarea.setEstadoTarea(rs.getString(7));                
                    tareas.add(tarea);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return tareas;   
    }

    
    
    @Override
    public boolean ingresar(Tarea tarea) throws Exception {
     
        String insertQuery = "INSERT INTO TAREA VALUES (TAREA_SEQ,?,?,?,?,?,?,?)";
       try {
             	pStmt = dbConnection.prepareStatement(insertQuery);
                
		pStmt.setInt(1, tarea.getId());
		pStmt.setString(2, tarea.getNombreTarea());
		pStmt.setDate(3, tarea.getFechaInicio());
                pStmt.setDate(4, tarea.getFechaTermino()); 
                pStmt.setString(5, tarea.getResponsable().getRut());                
                pStmt.setString(6, tarea.getEstadoTarea());
                pStmt.setInt(7, tarea.getProyecto().getId());                
        	pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());  
                return false;
	}         
      
    }

      @Override
    public boolean actualizar(Tarea tarea) throws Exception {      
      String updateQuery = "UPDATE TAREA SET ID_TAREA  "+
			   "NOMBRE_TAREA = ?, FECHA_INICIO = ?, "+
                            "FECHA_TERMINO = ?, RESPONSABLE = ?, "+
                           "ESTADO_TERMINADO = ?, ID_DETALLE_PROYECTO_TAREA = ? "+ 
                           "  ID_TAREA = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);	
		pStmt.setString(1, tarea.getNombreTarea());
		pStmt.setDate(2, tarea.getFechaInicio());
		pStmt.setDate(3, tarea.getFechaTermino());
                pStmt.setString(4, tarea.getResponsable().getRut());
		pStmt.setString(5, tarea.getEstadoTarea());
		pStmt.setInt(6, tarea.getProyecto().getId());
		pStmt.setInt(7, tarea.getId());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}   
    }

    @Override
    public Tarea buscarPorID(int id) throws Exception {
    Tarea tarea=new Tarea();
     String query = "SELECT * FROM TAREA WHERE ID_TAREA = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()){  
                    tarea.setId(rs.getInt(1));
                    tarea.setNombreTarea(rs.getString(2));
                    tarea.setFechaInicio(rs.getDate(3));
                    tarea.setFechaTermino(rs.getDate(4));
                    Empleado responsable= daoEmpleado.buscarPorID(rs.getString(5));
                    tarea.setResponsable(responsable);       
                    tarea.setEstadoTarea(rs.getString(6));
                    Proyecto proyecto = daoProyecto.buscarPorID(rs.getInt(7));
                    tarea.setProyecto(proyecto);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  tarea;    
    }
    
}
