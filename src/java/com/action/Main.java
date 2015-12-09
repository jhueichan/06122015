
package com.action;
import java.sql.Date;
import com.dao.DaoAfp;
import com.dao.DaoCiudad;
import com.dao.DaoEmpleado;
import com.dao.DaoEstadoCivil;
import com.dao.DaoFormaPago;
import com.dao.DaoMaquinaria;
import com.dao.DaoNacionalidad;
import com.dao.DaoPagina;
import com.dao.DaoPrevision;
import com.dao.DaoPrivilegios;
import com.dao.DaoPrivilegiosPagina;
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
import com.model.Pagina;
import com.model.Prevision;
import com.model.Privilegios;
import com.model.PrivilegiosPagina;
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
   

            DaoPrivilegiosPagina daoPrivilegiosPagina= new DaoPrivilegiosPagina();
        
            DaoPrivilegios daoPrivilegios = new DaoPrivilegios();
       
            DaoPagina daoPagina = new DaoPagina();      
            
            DaoEmpleado daoEmpleado= new DaoEmpleado();
            Empleado emp=daoEmpleado.buscarPorID("14298354");
            
            List<PrivilegiosPagina> lista;
           
            lista= daoPrivilegiosPagina.ListaPriviPaginaPorRol(emp.getRol());
            
            for (PrivilegiosPagina ls : lista) {
            
              System.out.println( "los datos son : " +ls.getPagina().getTitulo()+"  "+ls.getPagina().getUrl_());
                
                
           }
        
        
        
        
    }
    
}
