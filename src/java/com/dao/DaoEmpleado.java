package com.dao;
import com.model.Afp;
import com.model.Ciudad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import com.model.Empleado;
import com.model.EstadoCivil;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Rol;
import com.service.EmpleadoInterface;
import java.sql.CallableStatement;
import java.sql.Connection;



public class DaoEmpleado implements EmpleadoInterface {
    DaoCiudad daoCiudad= new DaoCiudad();
    DaoNacionalidad daoNacionalidad = new DaoNacionalidad();
    DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
    DaoAfp daoAfp = new DaoAfp();
    DaoPrevision daoPrevision = new DaoPrevision();
    DaoProfesion daoProfesion = new DaoProfesion();
    DaoRol daoRol = new DaoRol();     
    PreparedStatement pStmt; 
    CallableStatement csts;
    
    public DaoEmpleado() {          
      
    }
    
   
    @Override
    public boolean eliminar(String rut) throws Exception {
        String deleteQuery = "DELETE FROM EMPLEADO WHERE RUT = ?";
        try {
            pStmt = dbConnection.prepareStatement(deleteQuery);
            pStmt.setString(1, rut);
            pStmt.executeUpdate();
            return  true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public List <Empleado> listar() throws Exception {
     List<Empleado> empleados = new ArrayList<Empleado>();
   	String query = "SELECT * FROM EMPLEADO ORDER BY RUT";
	try {              
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		
                while (rs.next()) {
	        Empleado empleado = new Empleado();
               
                empleado.setRut(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidos(rs.getString(3));
                empleado.setDireccion(rs.getString(4));
                Ciudad ciudad=daoCiudad.buscarPorID(rs.getInt(5));
                empleado.setCiudad(ciudad);
                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(rs.getInt(6));
                empleado.setNacionalidad(nacionalidad);                
                empleado.setFechaNac(rs.getString(7));                
                EstadoCivil estado=daoEstadoCivil.buscarPorID(rs.getInt(8));
                empleado.setEstadoCivil(estado);
                empleado.setCargasFam(rs.getString(9));
                Afp afp= daoAfp.buscarPorID(rs.getInt(10));
                empleado.setAfp(afp);
                Prevision prevision=daoPrevision.buscarPorID(rs.getInt(11));
                empleado.setPrevision(prevision);                
                empleado.setTelefono(rs.getString(12));
                empleado.setEmail(rs.getString(13));
                Profesion  profesion= daoProfesion.buscarPorID(rs.getInt(14));
                empleado.setProfesion(profesion);
                Rol rol= daoRol.buscarPorID(rs.getInt(15));
                empleado.setRol(rol);                
                empleado.setPassword(rs.getString(16));
                empleados.add(empleado);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return empleados;        
    }

    
    
    
    @Override
    public boolean ingresar(Empleado empleado) throws Exception {
     Empleado emp = new Empleado();
        
        //System.out.println("el empleado vive en la ciudad de : "+emp.getCiudad().getNombre());
         
        try {
            csts = dbConnection.prepareCall("{call insertar_empleado(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
            csts.setString(1, empleado.getRut());
            csts.setString(2, empleado.getNombres());
            csts.setString(3, empleado.getApellidos());
            csts.setString(4, empleado.getDireccion());
            csts.setInt(5,empleado.getCiudad().getId());            
            csts.setInt(6, empleado.getNacionalidad().getId());
            csts.setString(7,empleado.getFechaNac());        
            csts.setInt(8,empleado.getEstadoCivil().getId());    
            csts.setString(9, empleado.getCargasFam());            
            csts.setInt(10, empleado.getAfp().getId());
            csts.setInt(11, empleado.getPrevision().getId());
            csts.setString(12, empleado.getTelefono());
            csts.setString(13, empleado.getEmail());
            csts.setInt(14, empleado.getProfesion().getId());
            csts.setInt(15, empleado.getRol().getId());
            csts.setString(16, empleado.getPassword());
            csts.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Empleado empleado) throws Exception {
         String updateQuery = "UPDATE EMPLEADO SET NOMBRES = ?,"
                                                 + "APELLIDOS = ?,"
                                                 + "DIRECCION = ?,"
                                                 + "CIUDAD_ID = ?,"
                                                 + "NACIONALIDAD_ID = ?,"
                                                 + "FECHA_NAC = ?,"
                                                 + "ESTADO_CIVIL_ID = ?,"
                                                 + "CARGAS_FAM = ?,"
                                                 + "AFP_ID = ?,"
                                                 + "PREVISION_ID = ?,"
                                                 + "TELEFONO = ?,"
                                                 + "EMAIL = ?,"
                                                 + "PROFESION_ID = ?,"
                                                 + "ROL_ID = ?,"
                                                 + "PASSWORD = ?"                                                
                                                 +"  WHERE RUT = ?";
        try {
            pStmt = dbConnection.prepareStatement(updateQuery);            
            
            pStmt.setString(1, empleado.getNombres());
            pStmt.setString(2, empleado.getApellidos());
            pStmt.setString(3, empleado.getDireccion());
            pStmt.setInt(4,empleado.getCiudad().getId());            
            pStmt.setInt(5, empleado.getNacionalidad().getId());
            pStmt.setString(6,empleado.getFechaNac());        
            pStmt.setInt(7,empleado.getEstadoCivil().getId());    
            pStmt.setString(8, empleado.getCargasFam());            
            pStmt.setInt(9, empleado.getAfp().getId());
            pStmt.setInt(10, empleado.getPrevision().getId());
            pStmt.setString(11, empleado.getTelefono());
            pStmt.setString(12, empleado.getEmail());
            pStmt.setInt(13, empleado.getProfesion().getId());
            pStmt.setInt(14, empleado.getRol().getId());
            pStmt.setString(15, empleado.getPassword());
            pStmt.setString(16, empleado.getRut());            
            pStmt.executeUpdate();
          return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    @Override
    public Empleado buscarPorID(String rut) throws Exception {
     Empleado empleado =new Empleado();
     String query = "SELECT * FROM EMPLEADO WHERE RUT = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setString(1,rut);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
                empleado.setRut(rs.getString(1));
                empleado.setNombres(rs.getString(2));
                empleado.setApellidos(rs.getString(3));
                empleado.setDireccion(rs.getString(4)); 
                Ciudad ciudad=daoCiudad.buscarPorID(rs.getInt(5));
                empleado.setCiudad(ciudad);
                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(rs.getInt(6));
                empleado.setNacionalidad(nacionalidad);                
                empleado.setFechaNac(rs.getString(7));                
                EstadoCivil estado=daoEstadoCivil.buscarPorID(rs.getInt(8));
                empleado.setEstadoCivil(estado);
                empleado.setCargasFam(rs.getString(9));
                Afp afp= daoAfp.buscarPorID(rs.getInt(10));
                empleado.setAfp(afp);
                Prevision prevision=daoPrevision.buscarPorID(rs.getInt(11));
                empleado.setPrevision(prevision);                
                empleado.setTelefono(rs.getString(12));
                empleado.setEmail(rs.getString(13));
                Profesion  profesion= daoProfesion.buscarPorID(rs.getInt(14));
                empleado.setProfesion(profesion);
                Rol rol= daoRol.buscarPorID(rs.getInt(15));
                empleado.setRol(rol);                
                empleado.setPassword(rs.getString(16));						 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  empleado;   
    
    }

 
    
    
}
