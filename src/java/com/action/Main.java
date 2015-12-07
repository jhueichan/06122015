
package com.action;
import java.sql.Date;
import com.dao.DaoAfp;
import com.dao.DaoCiudad;
import com.dao.DaoEmpleado;
import com.dao.DaoEstadoCivil;
import com.dao.DaoFormaPago;
import com.dao.DaoMaquinaria;
import com.dao.DaoNacionalidad;
import com.dao.DaoPrevision;
import com.dao.DaoProfesion;
import com.dao.DaoProveedor;
import com.dao.DaoProyecto;
import com.dao.DaoRol;
import com.dao.DaoTipoMaquinaria;
import com.model.Afp;
import com.model.Ciudad;
import com.model.Empleado;
import com.model.EstadoCivil;
import com.model.FormaPago;
import com.model.Maquinaria;
import com.model.Nacionalidad;
import com.model.Prevision;
import com.model.Profesion;
import com.model.Proveedor;
import com.model.Proyecto;
import com.model.Rol;
import com.model.TipoMaquinaria;
import static com.service.ProyectoInterfaz.dbConnection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
//    DaoEmpleado daoEmp=  new DaoEmpleado();
//    DaoCiudad daoCiudad = new DaoCiudad();
//    DaoNacionalidad daoNacionalidad = new DaoNacionalidad();
//    DaoEstadoCivil daoEstadoCivil = new DaoEstadoCivil();
//    DaoAfp daoAfp = new DaoAfp();
//    DaoPrevision daoPrevision = new DaoPrevision();
//    DaoProfesion daoProfesion = new DaoProfesion();
//    DaoRol daoRol = new DaoRol();
//    
//        
//    
//         Empleado empleado = new Empleado();  
//         
//                empleado.setRut("9283882");
//                empleado.setNombres("carlos");
//                empleado.setApellidos("carrasco");
//                empleado.setDireccion("111 norte 3451");              
//               
//                Ciudad  ciudad = daoCiudad.buscarPorID(2);                
//                empleado.setCiudad(ciudad);
//                
//                Nacionalidad nacionalidad= daoNacionalidad.buscarPorID(1);
//                empleado.setNacionalidad(nacionalidad);  
//                
//                Date fexNac= new Date(1983, 11, 07);
//                empleado.setFechaNac(fexNac);  
//                
//                EstadoCivil estado=daoEstadoCivil.buscarPorID(2);
//                empleado.setEstadoCivil(estado);
//                
//                empleado.setCargasFam("1");
//                
//                Afp afp= daoAfp.buscarPorID(3);
//                empleado.setAfp(afp);
//                Prevision prevision=daoPrevision.buscarPorID(1);
//                empleado.setPrevision(prevision);                
//                empleado.setTelefono("0323503293");
//                empleado.setEmail("jsdcds@gmail.com");
//                Profesion  profesion= daoProfesion.buscarPorID(1);
//                empleado.setProfesion(profesion);
//                Rol rol= daoRol.buscarPorID(1);
//                empleado.setRol(rol);                
//                empleado.setPassword("sdjfns");        
//        
//        daoEmp.ingresar(empleado);
//        
//        DaoTipoMaquinaria daoTipoMaquinaria = new DaoTipoMaquinaria();// en el dao Maquinaria
//        
//        
//        
//        TipoMaquinaria tipoMaq=daoTipoMaquinaria.buscaPorId(4);
//        DaoMaquinaria daoMaquinaria= new DaoMaquinaria();  // en el action
//        Maquinaria maquinaria= daoMaquinaria.buscarPorID("PP-23-43");
//        System.out.println("el tipo de la maquinaria es: "+maquinaria.getTipo_maq().getTipo());   
//       // System.out.println("el tipo de la maquinaria es: "+maquinaria.getTipo_maq().getTipo());
//       
//        List <Maquinaria> listaMaquinas = daoMaquinaria.listar();
//        
//         for (Maquinaria  maq  : listaMaquinas) {
//             System.out.println("el tipo es: "+maq.getTipo_maq().getTipo());
//             System.out.println("el tipo es: "+maq.getPatente());
//             System.out.println("el tipo es: "+maq.getPropia());
//             System.out.println("el tipo es: "+maq.getAnio());
//             System.out.println("el tipo es: "+maq.getValor_hora());
//             
//          //  maq.getTipo_maq().getTipo();
//        }
         
    
        
         
         
    }
    
}
