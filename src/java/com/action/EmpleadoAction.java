package com.action;



import com.dao.DaoAfp;
import com.dao.DaoCiudad;
import java.io.IOException;
import java.util.List;

import com.dao.DaoEmpleado;
import com.dao.DaoEstadoCivil;
import com.dao.DaoNacionalidad;
import com.dao.DaoPrevision;
import com.dao.DaoProfesion;
import com.dao.DaoRol;
import com.model.Afp;
import com.model.Ciudad;
import com.model.Empleado;
import com.model.EstadoCivil;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Rol;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import java.sql.Date;

public class EmpleadoAction {

    private DaoEmpleado dao = new DaoEmpleado();
    public List <Empleado> records;
    private String ciudades;
    private String nacionalidad;
    private String fechaNacimiento;
    private String estadoCivil;
    private String cargasFamiliares;
    private String prevision;
    private String afp;
    private String rol;
   
    
    private String result;
    private String message;
    private Empleado record;
    
    

     private String rut;
     private String nombres;
     private String apellidos;
     private String direccion;
     private Date fechaNac;
     private String cargasFam;
     private String telefono;
     private String email;
     private String password;     
     // claves foraneas  
 
  
        
     private Afp afp_id;
     private Ciudad ciudad_id;
     private EstadoCivil estado_civil_id;
     private Nacionalidad nacionalidad_id;
     private Prevision prevision_id;
     private Profesion profesion_id;
     private Rol rol_id;
        
     private ValueStack val;   
     private String codigoEmpleado;
     
      public String execute() throws Exception {
//        val = ActionContext.getContext().getValueStack();
//        dao.eliminar(codigoEmpleado);
//        val.push(record);
        return ActionSupport.SUCCESS;
    }
    
      public String list() {
        try {
            // Fetch Data from Proyecto Table
            records = dao.listar();
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
    
    public String create() throws IOException {
        record = new Empleado();

        
        record.setRut(this.rut);
        record.setNombres(this.nombres);
        record.setApellidos(this.apellidos);
        record.setDireccion(this.direccion);
        record.setFechaNac(this.fechaNac);
        record.setCargasFam(this.cargasFam);
        record.setTelefono(this.telefono);
        record.setEmail(this.email);
        record.setPassword(this.password);
        
//        record.setAfp_id(this.afp_id);
//        record.setCiudad_id(this.ciudad_id);
//        record.setEstado_civil_id(this.estado_civil_id);
//        record.setNacionalidad_id(this.nacionalidad_id);
//        record.setPrevision_id(this.prevision_id);
//        record.setProfesion_id(this.profesion_id);
//        record.setRol_id(this.rol_id);
        try {
            // Create new record
            dao.ingresar(record);
            result = "OK";

        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
        
    
	public String update() throws IOException {
        try {
                record.setRut(this.rut);
                record.setNombres(this.nombres);
                record.setApellidos(this.apellidos);
                record.setDireccion(this.direccion);   
                record.setCargasFam(this.cargasFam);
                record.setTelefono(this.telefono);
                record.setEmail(this.email);
                record.setPassword(this.password);
//                record.setAfp_id(this.afp_id);
//                record.setCiudad_id(this.ciudad_id);
//                record.setEstado_civil_id(this.estado_civil_id);
//                record.setNacionalidad_id(this.nacionalidad_id);
//                record.setPrevision_id(this.prevision_id);
//                record.setProfesion_id(this.profesion_id);
//                record.setRol_id(this.rol_id);
			// Update existing record
			dao.actualizar(record);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}

	public String delete() throws IOException {
		// Delete record
		try {
			dao.eliminar(this.rut);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}
        
        public Empleado buscaEmpleado() throws IOException {
        try {
            record = dao.buscarPorID(codigoEmpleado);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
//          System.out.println("articulo:  " + record.getArticulo());
//          System.out.println("codigo:  " + record.getCodigo());
//          System.out.println("marca:  " + record.getMarca());
//          System.out.println("medida:  " + record.getU_medida());

        return record;
    }
}