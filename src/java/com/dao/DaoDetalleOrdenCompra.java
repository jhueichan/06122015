
package com.dao;


import com.model.DetalleOrdenCompra;
import com.model.Material;
import com.model.OrdenCompra;
import com.service.DetalleOrdenCompraInterface;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoDetalleOrdenCompra implements DetalleOrdenCompraInterface {
    PreparedStatement pStmt;  
    DaoOrdenCompra daoOrdCom= new DaoOrdenCompra();
    DaoMaterial daoMat;
    
    public DaoDetalleOrdenCompra() {      
    }

    @Override
    public boolean eliminar(OrdenCompra orden ,Material  mat) throws Exception {
      String deleteQuery = "DELETE FROM MATER_OC "
              + "       WHERE ORDEN_COMPRA_NORDEN = ? "
              + "       AND  MATERIALES_CODIGO = ? ";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1 , orden.getNumero_orden());
                pStmt.setInt(2 , mat.getCodigo());
		pStmt.executeUpdate();
                return true;   
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;   
	}
        
    }

    @Override
    public List listar() throws Exception {
     List<DetalleOrdenCompra> ordenes = new ArrayList<DetalleOrdenCompra>();        
	String query = "SELECT * FROM MATER_OC";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		while (rs.next()) {
			DetalleOrdenCompra orden = new DetalleOrdenCompra();
                        
                        OrdenCompra ordeComp = daoOrdCom.buscarPorID(rs.getInt(1)); 
                        orden.setOrdenCompra(ordeComp);
                        Material mat=daoMat.buscaMatPorCodigo(rs.getInt(2));
                        orden.setMaterial(mat);
                        orden.setCantidad(rs.getInt(3));
                        orden.setUnidadMedida(rs.getString(4));
                        orden.setPrecioUnitario(rs.getDouble(5));
                        orden.setPrecioItem(rs.getDouble(6));                         
			ordenes.add(orden);	
                }
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return ordenes;
    }

    @Override
    public boolean ingresar(DetalleOrdenCompra obj) throws Exception {
       String insertQuery = "INSERT INTO MATER_OC VALUES (?,?,?,?,?,?)";
       try {
        	pStmt = dbConnection.prepareStatement(insertQuery); 
                
		pStmt.setInt(1, obj.getOrdenCompra().getNumero_orden());
                pStmt.setInt(2, obj.getMaterial().getCodigo());
                pStmt.setInt(3, obj.getCantidad());
                pStmt.setString(4, obj.getUnidadMedida());
                pStmt.setDouble(5,obj.getPrecioUnitario());
                pStmt.setDouble(6,obj.getPrecioItem());
                
                pStmt.executeUpdate();
            return true;      
	} catch (SQLException e) {
		System.err.println(e.getMessage());   
           return false;
	}         
     }

    @Override
    public boolean actualizar(DetalleOrdenCompra obj) throws Exception {
      String updateQuery = "UPDATE ORDEN_COMPRA SET  "
              +             "CANTIDAD = ?, U_MEDIDA = ? "
              +             "PRECIO_UNIT = ?, PRECIO_ITEM = ?  "              
              + "WHERE ORDEN_COMPRA_NORDEN = ? AND  MATERIALES_CODIGO = ? ";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);
                 pStmt.setInt(1, obj.getCantidad());
                pStmt.setString(2, obj.getUnidadMedida());
                  pStmt.setDouble(3,obj.getPrecioUnitario());
                 pStmt.setDouble(4,obj.getPrecioItem());                   
		pStmt.setInt(7, obj.getOrdenCompra().getNumero_orden());
                pStmt.setInt(8, obj.getMaterial().getCodigo());  
              
        
		pStmt.executeUpdate();
                     return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public  DetalleOrdenCompra buscarPorID(OrdenCompra orden ,Material  mat) throws Exception {
     DetalleOrdenCompra DetOrdenCom=new DetalleOrdenCompra();
     String query = "SELECT * FROM MATER_OC"
                    + " WHERE ORDEN_COMPRA_NORDEN = ?"
                     + " AND  MATERIALES_CODIGO = ?";   
      try {
                  pStmt = dbConnection.prepareStatement(query);            
		   pStmt.setInt(1 , orden.getNumero_orden());
                  pStmt.setInt(2 , mat.getCodigo());
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
		        OrdenCompra ordeComp = daoOrdCom.buscarPorID(rs.getInt(1)); 
                        DetOrdenCom.setOrdenCompra(ordeComp);
                        Material material=daoMat.buscaMatPorCodigo(rs.getInt(2));
                        DetOrdenCom.setMaterial(material);
                        DetOrdenCom.setCantidad(rs.getInt(3));
                        DetOrdenCom.setUnidadMedida(rs.getString(4));
                        DetOrdenCom.setPrecioUnitario(rs.getDouble(5));
                        DetOrdenCom.setPrecioItem(rs.getDouble(6)); 	
                        
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return  DetOrdenCom;   
    }


}
