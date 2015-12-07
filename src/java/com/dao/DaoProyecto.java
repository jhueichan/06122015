
package com.dao;
import com.model.Empleado;
import com.model.Proyecto;
import com.service.ProyectoInterfaz;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.CallableStatement;

public class DaoProyecto implements ProyectoInterfaz{
 DaoEmpleado daoEmpleado= new DaoEmpleado();
  
 PreparedStatement pStmt;  
 CallableStatement csts;
public DaoProyecto() {        
   }

    @Override
    public boolean eliminar(int id) throws Exception {
        String deleteQuery = "DELETE FROM PROYECTO WHERE ID = ?";
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
       List<Proyecto> proyectos = new ArrayList<Proyecto>();
      	String query = "SELECT * FROM PROYECTO ORDER BY ID";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
                    Empleado emp1 = new Empleado();
                    Empleado emp2 = new Empleado();                    
	            Proyecto proyecto = new Proyecto();
                    
                    proyecto.setId(rs.getInt(1));
                    proyecto.setUbicacion(rs.getString(2));
                    proyecto.setDescripcion(rs.getString(3));
                    proyecto.setFecha_inicio(rs.getDate(4).toString());
                    proyecto.setFecha_termino(rs.getDate(5).toString());
                    emp1=daoEmpleado.buscarPorID(rs.getString(6));
                    proyecto.setIngeniero_originador(emp1);
                    emp2=daoEmpleado.buscarPorID(rs.getString(7));
                    proyecto.setJefe_proyecto(emp2);                    
                    proyecto.setNombre(rs.getString(8));
                    proyectos.add(proyecto);
                    
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return proyectos;   
    }

    
    
    @Override
    public boolean ingresar(Proyecto proyecto) throws Exception {
           
       try {    
                csts = dbConnection.prepareCall("{call insertar_proyecto(?,?,?,?,?,?,?)}");
               	csts.setString(1, proyecto.getUbicacion());
		csts.setString(2, proyecto.getDescripcion());
		csts.setString(3,proyecto.getFecha_inicio() );
                csts.setString(4, proyecto.getFecha_termino()); 
                csts.setString(5, proyecto.getIngeniero_originador().getRut());                
                csts.setString(6, proyecto.getJefe_proyecto().getRut());
                csts.setString(7, proyecto.getNombre());         
  
                csts.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());               
	}         
       return true;
    }
       
    @Override
    public boolean actualizar(Proyecto proyecto) throws Exception {
     
      String updateQuery = "UPDATE PROYECTO SET UBICACION = ?, " +
			   "DESCRIPCION = ?, FECHA_INICIO = ?, "+
                            "FECHA_TERMINO = ?, INGENIERO_ORIGINADOR = ?, "+
                           "JEFE_PROYECTO = ?, NOMBRE = ? "+ 
                           " WHERE ID = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, proyecto.getUbicacion());
		pStmt.setString(2, proyecto.getDescripcion());
		pStmt.setString(3, proyecto.getFecha_inicio());
		pStmt.setString(4, proyecto.getFecha_termino());
                pStmt.setString(5, proyecto.getIngeniero_originador().getRut());
		pStmt.setString(6, proyecto.getJefe_proyecto().getRut());
		pStmt.setString(7, proyecto.getNombre());
		pStmt.setInt(8, proyecto.getId());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}           
    }

    @Override
    public Proyecto buscarPorID(int id) throws Exception {
      Proyecto proyecto=new Proyecto();
     String query = "SELECT * FROM PROYECTO WHERE ID = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setInt(1,id);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {                    
                    Empleado emp1 = new Empleado();
                    Empleado emp2 = new Empleado();                  
                    proyecto.setId(rs.getInt(1));
                    proyecto.setUbicacion(rs.getString(2));
                    proyecto.setDescripcion(rs.getString(3));
                    proyecto.setFecha_inicio(rs.getDate(4).toString());
                    proyecto.setFecha_termino(rs.getDate(5).toString());
                    emp1=daoEmpleado.buscarPorID(rs.getString(6));
                    proyecto.setIngeniero_originador(emp1);
                    emp2=daoEmpleado.buscarPorID(rs.getString(7));
                    proyecto.setJefe_proyecto(emp2);
                    proyecto.setNombre(rs.getString(8));
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  proyecto;   
    }
    
}
