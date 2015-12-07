
package com.service;

import com.dao.DaoAfp;
import com.dao.DaoCiudad;
import com.dao.DaoEstadoCivil;
import com.dao.DaoNacionalidad;
import com.dao.DaoPrevision;
import com.dao.DaoProfesion;
import com.dao.DaoRol;
import com.jdbc.DataAccessObject;
import com.model.Empleado;
import java.sql.Connection;
import java.util.List;

public interface EmpleadoInterface {
        
    public static Connection dbConnection= DataAccessObject.getConnection();  
   
    public static DaoCiudad daoCiudad=new DaoCiudad();
    public static DaoNacionalidad daoNacionalidad=new DaoNacionalidad();
    public static DaoEstadoCivil daoEstadoCivil= new DaoEstadoCivil();
    public static DaoAfp daoAfp= new DaoAfp();
    public static DaoPrevision daoPrevision= new DaoPrevision();
    public static DaoProfesion daoProfesion= new DaoProfesion();
    public static DaoRol daoRol= new DaoRol();  
    
    
    public boolean eliminar(String  rut) throws Exception;
    public List <Empleado> listar() throws Exception;
    public boolean ingresar(Empleado obj) throws Exception;   
    public boolean actualizar(Empleado obj) throws Exception;
    public Empleado buscarPorID(String rut) throws Exception;
    
}
