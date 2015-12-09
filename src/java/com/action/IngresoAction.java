
package com.action;

import com.dao.DaoEmpleado;
import com.dao.DaoPagina;
import com.dao.DaoPrivilegiosPagina;
import com.model.Empleado;
import com.model.PrivilegiosPagina;
import static com.opensymphony.xwork2.Action.ERROR;
import static com.opensymphony.xwork2.Action.SUCCESS;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;
import java.util.Map;


public class IngresoAction extends ActionSupport{
      
    
      public final DaoPagina daoPagina= new DaoPagina();
      public String rutIngresado;
      public String passwordIngresada;      
      public List<PrivilegiosPagina> listarPaginas;
   
      
      public boolean credencialesVacias(){
          if (rutIngresado==null || passwordIngresada==null) {
             return true;
          } else {
              return false;
          }     
      }
      
      
      
      public String IniciarSesion() throws Exception{
          
          Empleado empleado=new Empleado();
          DaoEmpleado  daoEmpleado = new DaoEmpleado();
          if (credencialesVacias()) {
              addActionMessage("error, Ingrese credenciales ");            
              return ERROR;           
          } else {
                     try { 
                         empleado = daoEmpleado.buscarPorID(rutIngresado);
                         System.out.println("nombre emp: "+empleado.getNombres());
                         System.out.println("emp password"+empleado.getPassword());
                         System.out.println("pas de la jsp"+passwordIngresada);
                      } catch (Exception e) {
                          addActionMessage("el usuario no existe, ingrese un rut valido");        
                          System.out.println(e.getMessage());  
                          return ERROR;      
                      }

                     if (passwordIngresada.equals(empleado.getPassword())) {
                        System.out.println("los rut son iguales ");    
                        DaoPrivilegiosPagina daoPrivilegiosPagina= new DaoPrivilegiosPagina();                 
                        listarPaginas= daoPrivilegiosPagina.ListaPriviPaginaPorRol(empleado.getRol());
                        
                         Map <String, Object> sesionEmpleado = ActionContext.getContext().getSession();
                         sesionEmpleado.put("sesionEmpleado", empleado);                      
                         addActionMessage("Bienvenido : " + empleado.getNombres()+" "+empleado.getApellidos());   
                         return SUCCESS;  
                    } else {           
                          addActionError("la  password son Incorrectos");
                          return ERROR;      
                    }        
          }         
    } 
      
      
      
      
    public String cerrarSesion() {
        try {
            Map sessionLogout = ActionContext.getContext().getSession();
            sessionLogout.remove("sesionEmpleado");
            addActionMessage("Has salido de su sesion");
            return SUCCESS;
        } catch (Exception e) {
             System.out.println("error valida en el action ----> CerrarSesion"+e.getMessage());
             return SUCCESS;
        }
       
       
     }


    public String getRutIngresado() {
        return rutIngresado;
    }

    public void setRutIngresado(String rutIngresado) {
        this.rutIngresado = rutIngresado;
    }

    public String getPasswordIngresada() {
        return passwordIngresada;
    }

    public void setPasswordIngresada(String passwordIngresada) {
        this.passwordIngresada = passwordIngresada;
    }

    public List<PrivilegiosPagina> getLista() {
        return listarPaginas;
    }

    public void setLista(List<PrivilegiosPagina> lista) {
        this.listarPaginas = lista;
    }

 

 
    
}
