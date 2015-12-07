/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.DetallePedido;
import com.model.Material;
import com.model.SolicitudPedido;
import com.service.DetallePedidoInterface;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class DaoDetallePedido implements DetallePedidoInterface{
     PreparedStatement pStmt;
        
    @Override
    public boolean eliminar(Material mat, SolicitudPedido solPedido) throws Exception {
      String deleteQuery = "DELETE FROM DETALLE_PEDIDO "
              + "       WHERE SOL_PEDIDO_NSOLICITUD = ? "
              + "       AND  MATERIALES_CODIGO = ? ";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setInt(1 , solPedido.getNumeroSol());
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean ingresar(DetallePedido obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean actualizar(DetallePedido obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DetallePedido buscarPorID(Material mat, SolicitudPedido solPedido) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
