
package com.action;

import com.dao.DaoMaquinaria;
import com.model.Maquinaria;
import com.model.TipoMaquinaria;
import java.io.IOException;
import java.util.List;
import com.opensymphony.xwork2.Action;


public class MaquinariaAccion {
    
    private DaoMaquinaria dao = new DaoMaquinaria();
    
    private List<Maquinaria> records;
    
	private String result;
	private String message;
        private Maquinaria record;
        private TipoMaquinaria tipoMaq= new TipoMaquinaria();

        private String patente;
	private int tipo_maq;
	private int anio;
	private String propia;
        private int valor_hora;

        
        public String list() {
		try {
	
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
		record = new Maquinaria();
		
		record.setPatente(this.patente);
                tipoMaq.setId(this.tipo_maq);                
		record.setTipo_maq(tipoMaq);
                record.setAnio(this.anio);
		record.setPropia(this.propia);
                record.setValor_hora(this.valor_hora);
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
        
        public String update() throws IOException{
            
        try {
        record.setPatente(patente);
        tipoMaq.setId(this.tipo_maq);
        record.setTipo_maq(tipoMaq);
        record.setAnio(anio);
        record.setPropia(propia);
        record.setValor_hora(valor_hora);
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
                        dao.eliminar(this.patente);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}
		return Action.SUCCESS;
	}
        
        
      private int codigoMaquinaria;
      
      public  String  buscaMaqPorPatente() throws IOException {
      try {
                       
             System.out.println("recurso de la jsp:  " + codigoMaquinaria);
             record = dao.buscarPorID(patente);
			result = "OK";
		} catch (Exception e) {
			result = "ERROR";
			message = e.getMessage();
			System.err.println(e.getMessage());
		}     
      
      
          System.out.println("Patente:  " + record.getPatente());
          System.out.println("Tipo Maquinaria:  " + record.getTipo_maq());
          System.out.println("Año:  " + record.getAnio());
          System.out.println("Propia:  " + record.getPropia());
          System.out.println("Valor Hora:  " + record.getValor_hora());
		return Action.SUCCESS;
      }

    public DaoMaquinaria getDao() {
        return dao;
    }

    public void setDao(DaoMaquinaria dao) {
        this.dao = dao;
    }

    public List<Maquinaria> getRecords() {
        return records;
    }

    public void setRecords(List<Maquinaria> records) {
        this.records = records;
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

    public Maquinaria getRecord() {
        return record;
    }

    public void setRecord(Maquinaria record) {
        this.record = record;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getTipo_maq() {
        return tipo_maq;
    }

    public void setTipo_maq(int tipo_maq) {
        this.tipo_maq = tipo_maq;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public String getPropia() {
        return propia;
    }

    public void setPropia(String propia) {
        this.propia = propia;
    }

    public int getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(int valor_hora) {
        this.valor_hora = valor_hora;
    }

    public int getCodigoMaquinaria() {
        return codigoMaquinaria;
    }

    public void setCodigoMaquinaria(int codigoMaquinaria) {
        this.codigoMaquinaria = codigoMaquinaria;
    }

    public TipoMaquinaria getTipoMaq() {
        return tipoMaq;
    }

    public void setTipoMaq(TipoMaquinaria tipoMaq) {
        this.tipoMaq = tipoMaq;
    }

        
}
