
package com.model;


public class Maquinaria {
    private String patente;
    private TipoMaquinaria tipo_maq;
    private int anio;
    private String propia;
    private int valor_hora;

    public Maquinaria() {
    }
    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public TipoMaquinaria getTipo_maq() {
        return tipo_maq;
    }

    public void setTipo_maq(TipoMaquinaria tipo_maq) {
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

    
    
}
