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
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

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
    private String profesion;
   
    
    private String result;
    private String message;
    private Empleado record;
    
    

     private String rut;
     private String nombres;
     private String apellidos;
     private String direccion;
     private String fechaNac;
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
    
      
      public DaoCiudad  daoCiu = new DaoCiudad();
      public List<Ciudad> listaCiudades;
      public DaoNacionalidad daoNac = new DaoNacionalidad();
      public List<Nacionalidad> listaNacionalidad;
      public DaoEstadoCivil daoEstadoCiv = new DaoEstadoCivil();
      public List<EstadoCivil> listaEstadoCivil;
      public DaoAfp daoAfps = new DaoAfp();
      public List<Afp> listaAfp;
      public DaoPrevision daoPrev = new DaoPrevision();
      public List<Prevision> listaPrevision;
      public DaoProfesion daoProf = new DaoProfesion();
      public List<Profesion> listaProfesion;
      public DaoRol daoRoles = new DaoRol();
      public List<Rol> listaRoles;
               
      
      public String list() {
          
        try {
            // Fetch Data from Proyecto Table
            records = dao.listar();
            result = "OK";
            listaCiudades = daoCiu.listar();
            listaNacionalidad = daoNac.listar();
            listaEstadoCivil = daoEstadoCiv.listar();
            listaAfp = daoAfps.listar();
            listaPrevision = daoPrev.listar();
            listaProfesion = daoProf.listar();
            listaRoles = daoRoles.listar();
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        return Action.SUCCESS;
    }
    
      
    public int IdAfp;
    public int IdCiudad;
    public int IdEstadoCivil;
    public int IdNacionalidad;
    public int IdPrevision;
    public int IdProfesion;
    public int IdRol;
    
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
        Afp miAfp = new Afp();
        miAfp.setId(IdAfp);
        record.setAfp(miAfp);
        
        Ciudad miCiudad = new Ciudad();
        miCiudad.setId(IdCiudad);
        record.setCiudad(miCiudad);
        
        EstadoCivil miEstado = new EstadoCivil();
        miEstado.setId(IdEstadoCivil);
        record.setEstadoCivil(miEstado);
        
        Nacionalidad miNacionalidad = new Nacionalidad();
        miNacionalidad.setId(IdNacionalidad);
        record.setNacionalidad(miNacionalidad);
        
        Prevision miPrevision = new Prevision();
        miPrevision.setId(IdPrevision);
        record.setPrevision(miPrevision);
        
        Profesion miProfesion = new Profesion();
        miProfesion.setId(IdProfesion);
        record.setProfesion(miProfesion);
        
        Rol miRol = new Rol();
        miRol.setId(IdRol);
        record.setRol(miRol);
     
        
        
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
                
                Afp miafp = new Afp();
                miafp.setId(IdAfp);
                record.setAfp(miafp);
                
                Ciudad miciudad = new Ciudad();
                miciudad.setId(IdCiudad);
                record.setCiudad(miciudad);
                
                EstadoCivil miestadocivil = new EstadoCivil();
                miestadocivil.setId(IdEstadoCivil);
                record.setEstadoCivil(miestadocivil);
                
                Nacionalidad minacionalidad = new Nacionalidad();
                minacionalidad.setId(IdNacionalidad);
                record.setNacionalidad(minacionalidad);
                
                Prevision miprevision = new Prevision();
                miprevision.setId(IdPrevision);
                record.setPrevision(miprevision);
                
                Profesion miprofesion = new Profesion();
                miprofesion.setId(IdProfesion);
                record.setProfesion(miprofesion);
                
                Rol mirol = new Rol();
                mirol.setId(IdRol);
                record.setRol(mirol);
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
        
        public String buscaEmpleado() throws IOException {
        try {
            System.out.println("recurso de la jsp:  " + codigoEmpleado);
            record = dao.buscarPorID(codigoEmpleado);
            result = "OK";
        } catch (Exception e) {
            result = "ERROR";
            message = e.getMessage();
            System.err.println(e.getMessage());
        }
        System.out.println("rut:  " + record.getRut());
        System.out.println("nombres:  " + record.getNombres());
        System.out.println("apellidos:  " + record.getApellidos());
        System.out.println("direccion:  " + record.getDireccion());
        System.out.println("ciudad:  " + record.getCiudad().getId());
        System.out.println("nacionalidad:  " + record.getNacionalidad().getPais());
        System.out.println("fecha nacimiento:  " + record.getFechaNac());
        System.out.println("estado civil:  " + record.getEstadoCivil().getId());
        System.out.println("cargas:  " + record.getCargasFam());
        System.out.println("afp:  " + record.getAfp().getId());
        System.out.println("prevision:  " + record.getPrevision().getId());
        System.out.println("telefono:  " + record.getTelefono());
        System.out.println("email:  " + record.getEmail());
        System.out.println("profesion:  " + record.getProfesion().getId());
        System.out.println("rol:  " + record.getRol().getId());
        System.out.println("password:  " + record.getPassword());
        return Action.SUCCESS;
        
    }

    public DaoEmpleado getDao() {
        return dao;
    }

    public void setDao(DaoEmpleado dao) {
        this.dao = dao;
    }

    public List<Empleado> getRecords() {
        return records;
    }

    public void setRecords(List<Empleado> records) {
        this.records = records;
    }

    public String getCiudades() {
        return ciudades;
    }

    public void setCiudades(String ciudades) {
        this.ciudades = ciudades;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getCargasFamiliares() {
        return cargasFamiliares;
    }

    public void setCargasFamiliares(String cargasFamiliares) {
        this.cargasFamiliares = cargasFamiliares;
    }

    public String getPrevision() {
        return prevision;
    }

    public void setPrevision(String prevision) {
        this.prevision = prevision;
    }

    public String getAfp() {
        return afp;
    }

    public void setAfp(String afp) {
        this.afp = afp;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Empleado getRecord() {
        return record;
    }

    public void setRecord(Empleado record) {
        this.record = record;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
        this.fechaNac = fechaNac;
    }

    public String getCargasFam() {
        return cargasFam;
    }

    public void setCargasFam(String cargasFam) {
        this.cargasFam = cargasFam;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Afp getAfp_id() {
        return afp_id;
    }

    public void setAfp_id(Afp afp_id) {
        this.afp_id = afp_id;
    }

    public Ciudad getCiudad_id() {
        return ciudad_id;
    }

    public void setCiudad_id(Ciudad ciudad_id) {
        this.ciudad_id = ciudad_id;
    }

    public EstadoCivil getEstado_civil_id() {
        return estado_civil_id;
    }

    public void setEstado_civil_id(EstadoCivil estado_civil_id) {
        this.estado_civil_id = estado_civil_id;
    }

    public Nacionalidad getNacionalidad_id() {
        return nacionalidad_id;
    }

    public void setNacionalidad_id(Nacionalidad nacionalidad_id) {
        this.nacionalidad_id = nacionalidad_id;
    }

    public Prevision getPrevision_id() {
        return prevision_id;
    }

    public void setPrevision_id(Prevision prevision_id) {
        this.prevision_id = prevision_id;
    }

    public Profesion getProfesion_id() {
        return profesion_id;
    }

    public void setProfesion_id(Profesion profesion_id) {
        this.profesion_id = profesion_id;
    }

    public Rol getRol_id() {
        return rol_id;
    }

    public void setRol_id(Rol rol_id) {
        this.rol_id = rol_id;
    }

    public ValueStack getVal() {
        return val;
    }

    public void setVal(ValueStack val) {
        this.val = val;
    }

    public String getCodigoEmpleado() {
        return codigoEmpleado;
    }

    public void setCodigoEmpleado(String codigoEmpleado) {
        this.codigoEmpleado = codigoEmpleado;
    }

    public DaoCiudad getDaoCiu() {
        return daoCiu;
    }

    public void setDaoCiu(DaoCiudad daoCiu) {
        this.daoCiu = daoCiu;
    }

    public List<Ciudad> getListaCiudades() {
        return listaCiudades;
    }

    public void setListaCiudades(List<Ciudad> listaCiudades) {
        this.listaCiudades = listaCiudades;
    }

    public DaoNacionalidad getDaoNac() {
        return daoNac;
    }

    public void setDaoNac(DaoNacionalidad daoNac) {
        this.daoNac = daoNac;
    }

    public List<Nacionalidad> getListaNacionalidad() {
        return listaNacionalidad;
    }

    public void setListaNacionalidad(List<Nacionalidad> listaNacionalidad) {
        this.listaNacionalidad = listaNacionalidad;
    }

    public DaoEstadoCivil getDaoEstadoCiv() {
        return daoEstadoCiv;
    }

    public void setDaoEstadoCiv(DaoEstadoCivil daoEstadoCiv) {
        this.daoEstadoCiv = daoEstadoCiv;
    }

    public List<EstadoCivil> getListaEstadoCivil() {
        return listaEstadoCivil;
    }

    public void setListaEstadoCivil(List<EstadoCivil> listaEstadoCivil) {
        this.listaEstadoCivil = listaEstadoCivil;
    }

    public DaoAfp getDaoAfps() {
        return daoAfps;
    }

    public void setDaoAfps(DaoAfp daoAfps) {
        this.daoAfps = daoAfps;
    }

    public List<Afp> getListaAfp() {
        return listaAfp;
    }

    public void setListaAfp(List<Afp> listaAfp) {
        this.listaAfp = listaAfp;
    }

    public DaoPrevision getDaoPrev() {
        return daoPrev;
    }

    public void setDaoPrev(DaoPrevision daoPrev) {
        this.daoPrev = daoPrev;
    }

    public List<Prevision> getListaPrevision() {
        return listaPrevision;
    }

    public void setListaPrevision(List<Prevision> listaPrevision) {
        this.listaPrevision = listaPrevision;
    }

    public DaoProfesion getDaoProf() {
        return daoProf;
    }

    public void setDaoProf(DaoProfesion daoProf) {
        this.daoProf = daoProf;
    }

    public List<Profesion> getListaProfesion() {
        return listaProfesion;
    }

    public void setListaProfesion(List<Profesion> listaProfesion) {
        this.listaProfesion = listaProfesion;
    }

    public DaoRol getDaoRoles() {
        return daoRoles;
    }

    public void setDaoRoles(DaoRol daoRoles) {
        this.daoRoles = daoRoles;
    }

    public List<Rol> getListaRoles() {
        return listaRoles;
    }

    public void setListaRoles(List<Rol> listaRoles) {
        this.listaRoles = listaRoles;
    }

}