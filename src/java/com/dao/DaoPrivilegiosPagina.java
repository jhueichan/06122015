
package com.dao;

import com.model.Pagina;
import com.model.Privilegios;
import com.model.PrivilegiosPagina;
import com.model.Rol;
import com.service.PrivilegiosPaginaInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoPrivilegiosPagina  implements PrivilegiosPaginaInterface {
    
     PreparedStatement pStmt;     
     private  DaoPrivilegios daoPrivilegios=new DaoPrivilegios();     
     private   DaoPagina daoPagina= new DaoPagina();
     
     public DaoPrivilegiosPagina() {
    }
  
    @Override
    public boolean eliminar(int privpagina) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<PrivilegiosPagina> listar() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresar(PrivilegiosPagina obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(PrivilegiosPagina obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PrivilegiosPagina buscarPorID(int privpagina) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
     public List<PrivilegiosPagina> ListaPriviPaginaPorRol(Rol rol) throws Exception {
     
         List<PrivilegiosPagina> listPrivilegiosPaginas= new ArrayList<PrivilegiosPagina>();
         String query = "SELECT * FROM PRIVILEGIOS_PAGINA WHERE IDPRIV = ?";   
        try {
                  pStmt = dbConnection.prepareStatement(query);
                  
		  pStmt.setInt(1,rol.getPrivilegios().getIdpriv());
                  System.out.println("el idpiv: "+rol.getPrivilegios().getIdpriv());
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
                        PrivilegiosPagina  priPag = new PrivilegiosPagina();
			
                        priPag.setPrivpagina(rs.getInt(1));                        
                        Privilegios pri=daoPrivilegios.buscarPorID(rs.getInt(2));                       
                        priPag.setPrivilegio(pri);                         
                        Pagina pag=daoPagina.buscarPorID(rs.getInt(3));
			priPag.setPagina(pag);
                        
                        listPrivilegiosPaginas.add(priPag);                       			 	
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  listPrivilegiosPaginas;   
     
     }
    
      
      
      
      
      
      
}
