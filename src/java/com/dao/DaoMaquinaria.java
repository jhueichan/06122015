package com.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.model.Maquinaria;
import com.model.TipoMaquinaria;
import com.service.MaquinariaInterface;


public class DaoMaquinaria implements MaquinariaInterface {

DaoTipoMaquinaria dtm= new DaoTipoMaquinaria();
PreparedStatement pStmt;

public DaoMaquinaria() {
        
}  
        
    @Override
    public boolean eliminar(String patente) throws Exception {
       
        String deleteQuery = "DELETE FROM MAQUINARIA WHERE PATENTE = ?";
	try {
		pStmt = dbConnection.prepareStatement(deleteQuery);
		pStmt.setString(1, patente);
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
        
    }

    @Override
    public  List<Maquinaria>  listar() throws Exception {
        
        List  <Maquinaria> maquinarias = new ArrayList<Maquinaria>();

	String query = "SELECT * FROM MAQUINARIA ORDER BY PATENTE";
	try {
		Statement stmt = dbConnection.createStatement();
		ResultSet rs = stmt.executeQuery(query);         
                
		while (rs.next()) {
			Maquinaria maquinaria = new Maquinaria();
                        
                        maquinaria.setPatente(rs.getString(1)); 
                        
                        TipoMaquinaria tipoMaq= dtm.buscaPorId(rs.getInt(2));       
                        maquinaria.setTipo_maq(tipoMaq);
			maquinaria.setAnio(rs.getInt(3));
			maquinaria.setPropia(rs.getString(4));
                        maquinaria.setValor_hora(rs.getInt(5));
                        
			maquinarias.add(maquinaria);
		}
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}
	return maquinarias;
        
    }

    @Override
    public boolean ingresar(Maquinaria maquinaria) throws Exception {
        
       String insertQuery = "INSERT INTO MAQUINARIA(PATENTE, TIPO_MAQ, " +
			"ANO,PROPIA, VALOR_HORA) VALUES (INCREMENTO_MAQUINARIA_SEQ.NextVal,?,?,?,?)";
	try {
		pStmt = dbConnection.prepareStatement(insertQuery);             
		pStmt.setString(1, maquinaria.getPatente());
		pStmt.setInt(2,maquinaria.getTipo_maq().getId());
		pStmt.setInt(3, maquinaria.getAnio());
                pStmt.setString(4, maquinaria.getPropia());
                pStmt.setInt(5, maquinaria.getValor_hora());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public boolean actualizar(Maquinaria maquinaria) throws Exception {
        
        
        String updateQuery = "UPDATE MAQUINARIA SET PATENTE = ?, " +
			"TIPO_MAQ = ?, ANO = ? ,PROPIA = ? ,VALOR_HORA = ?  WHERE PATENTE = ?";
	try {
		pStmt = dbConnection.prepareStatement(updateQuery);		
		pStmt.setString(1, maquinaria.getPatente());
		pStmt.setInt(2, maquinaria.getTipo_maq().getId());
		pStmt.setInt(3, maquinaria.getAnio());
		pStmt.setString(4, maquinaria.getPropia());
                pStmt.setInt(5, maquinaria.getValor_hora());
		pStmt.executeUpdate();
                return true;
	} catch (SQLException e) {
		System.err.println(e.getMessage());
                return false;
	}
    }

    @Override
    public Maquinaria buscarPorID(String patente) throws Exception {
        
        Maquinaria maquinaria= new Maquinaria();        
          String query = "SELECT * FROM MAQUINARIA WHERE PATENTE = ?";   
         //String query  = "call buscaMaterialPorCodigo(?);";	
         try {
                  pStmt = dbConnection.prepareStatement(query);            
		  pStmt.setString(1,patente);	
                  ResultSet rs = pStmt.executeQuery();                 
		while (rs.next()) {
                    
			maquinaria.setPatente(rs.getString(1));
                        TipoMaquinaria tipoMaq= dtm.buscaPorId(rs.getInt(2));                                            
			maquinaria.setTipo_maq(tipoMaq);
                        maquinaria.setAnio(rs.getInt(3));
			maquinaria.setPropia(rs.getString(4));
                        maquinaria.setValor_hora(rs.getInt(5));
		}
                
	} catch (SQLException e) {
		System.err.println(e.getMessage());
	}   
        return maquinaria;
    }
        
        
        
        
        
        
        
        
        
        
        
        
        
}
